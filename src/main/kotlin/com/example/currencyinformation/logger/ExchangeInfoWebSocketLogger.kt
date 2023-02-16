package com.example.currencyinformation.logger

import com.example.currencyinformation.persistence.entity.CurrencyRule
import com.example.currencyinformation.persistence.repository.CurrencyConfigRepository
import com.example.currencyinformation.service.api.CurrencyInfoWebSocketService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import kotlin.random.Random.Default as Random


@Component
internal class ExchangeInfoWebSocketLogger(
        private val currencyInfoWebSocketService: CurrencyInfoWebSocketService,
        private val currencyConfigRepository: CurrencyConfigRepository
) : CommandLineRunner {


    override fun run(vararg args: String?): Unit = runBlocking {
        currencyConfigRepository.findAll().asFlow()
                .filter { it.isEnabled && it.percent >= Random.nextInt(0, 100) }
                .map { config ->
                    val streamNames = config.rules.filter(CurrencyRule::isEnabled).map(CurrencyRule::streamName)
                    launch {
                        withContext(Dispatchers.IO) {
                            currencyInfoWebSocketService.subscribeToStreams(streamNames).block()
                        }
                    }
                }
    }
}