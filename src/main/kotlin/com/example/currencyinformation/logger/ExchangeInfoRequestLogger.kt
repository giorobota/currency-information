package com.example.currencyinformation.logger

import com.example.currencyinformation.configuration.LoggingConfiguration
import com.example.currencyinformation.service.api.CurrencyInformationWebService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ExchangeInfoRequestLogger(
        private val currencyInformationWebService: CurrencyInformationWebService,
        private val loggingConfiguration: LoggingConfiguration
) : CommandLineRunner {

    override fun run(vararg args: String?): Unit = runBlocking {
        if (loggingConfiguration.requestLoggerEnabled) {
            currencyInformationWebService.ping()
            launch {
                for (i in 0..1000) {
                    val info = currencyInformationWebService.exchangeInfo()
                    println("received response: ${info.toPrettyString()}")
                    delay(10_000)
                }
            }
        }
    }
}