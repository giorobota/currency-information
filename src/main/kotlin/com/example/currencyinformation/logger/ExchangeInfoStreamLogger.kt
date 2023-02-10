package com.example.currencyinformation.logger

import com.example.currencyinformation.service.api.CurrencyInformationWebSocketService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ExchangeInfoStreamLogger(
        private val service: CurrencyInformationWebSocketService
) : CommandLineRunner {

    override fun run(vararg args: String) {
        service.subscribeToSteam()
    }
}