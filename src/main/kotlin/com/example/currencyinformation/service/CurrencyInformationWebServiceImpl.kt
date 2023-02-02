package com.example.currencyinformation.service

import com.example.currencyinformation.service.api.CurrencyInformationWebService
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.stereotype.Component

private const val BASE_URL = ""
private const val EXCHANGE_INFO_URL = "/api/v3/exchangeInfo"
private const val PING_URL = "/api/v3/ping"
@Component
internal class CurrencyInformationWebServiceImpl: CurrencyInformationWebService {
    override fun ping() {
        TODO("Not yet implemented")
    }

    override fun exchangeInfo(): JsonNode {
        TODO("Not yet implemented")
    }
}