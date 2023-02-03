package com.example.currencyinformation.service

import com.example.currencyinformation.service.api.CurrencyInformationWebService
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import java.lang.IllegalStateException
import java.time.Duration

private const val BASE_URL = "https://data.binance.com"
private const val EXCHANGE_INFO_URL = "/api/v3/exchangeInfo"
private const val PING_URL = "/api/v3/ping"

@Component
internal class CurrencyInformationWebServiceImpl(
        builder: WebClient.Builder
) : CurrencyInformationWebService {

    private val webClient = builder.baseUrl(BASE_URL).build()

    override fun ping() {
        webClient
                .get()
                .uri(PING_URL)
                .retrieve()
                .bodyToMono<String>()
                .block()
    }

    override fun exchangeInfo(): JsonNode {
        val response = webClient
                .get()
                .uri(EXCHANGE_INFO_URL)
                .retrieve()
                .bodyToMono<JsonNode>()
                .timeout(Duration.ofSeconds(120))
                .block()

        return checkNotNull(response){
            "error receiving response for currency exchange info"
        }
    }
}