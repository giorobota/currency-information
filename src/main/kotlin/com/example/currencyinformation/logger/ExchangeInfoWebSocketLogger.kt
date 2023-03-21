package com.example.currencyinformation.logger

import com.example.currencyinformation.persistence.entity.CurrencyRule
import com.example.currencyinformation.persistence.repository.CurrencyConfigRepository
import com.example.currencyinformation.service.api.CurrencyInfoWebSocketService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import kotlin.random.Random.Default as Random


@Component
internal class ExchangeInfoWebSocketLogger(
        private val currencyInfoWebSocketService: CurrencyInfoWebSocketService,
        private val currencyConfigRepository: CurrencyConfigRepository
) : CommandLineRunner {


    @OptIn(DelicateCoroutinesApi::class)
    override fun run(vararg args: String?){
        GlobalScope.launch {
            currencyConfigRepository.findAll()
                    .asFlow()
                    .filter { it.isEnabled && it.percent >= Random.nextInt(0, 100) }
                    .collect { config ->
                        val streamNames = config.rules.filter(CurrencyRule::isEnabled).map(CurrencyRule::streamName)
                        launch {
                            withContext(Dispatchers.IO) {
                                currencyInfoWebSocketService.subscribeToStreams(streamNames).block()
                            }
                        }
                    }
        }
    }
}