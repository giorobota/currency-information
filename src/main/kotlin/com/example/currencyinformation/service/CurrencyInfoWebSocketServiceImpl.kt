package com.example.currencyinformation.service

import com.example.currencyinformation.persistence.service.api.CurrencyResultService
import com.example.currencyinformation.service.api.CurrencyInfoWebSocketService
import com.example.currencyinformation.service.api.model.CurrencyInfoResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import java.net.URI

@Component
internal class CurrencyInfoWebSocketServiceImpl(
        @Value("\${binance.base-url}")
        private val binanceBaseUrl: String,
        private val objectMapper: ObjectMapper,
        private val currencyResultService: CurrencyResultService
) : CurrencyInfoWebSocketService {

    private val logger = KotlinLogging.logger {}

    override fun subscribeToStreams(streamNames: List<String>) =
            ReactorNettyWebSocketClient().execute(
                    provideUri(streamNames)
            ) { session ->
                session.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .doOnError {
                            logger.error { "encountered error: ${it.message}" }
                        }
                        .doOnNext { rawResponse ->
                            logger.info { "received $rawResponse" }
                            val response = objectMapper.readValue<CurrencyInfoResponse>(rawResponse)
                            currencyResultService.saveResponse(response)
                        }
                        .retry()
                        .then()
            }


    private fun provideUri(streamNames: List<String>): URI {
        val url = binanceBaseUrl + streamNames.joinToString(separator = "/")

        return URI(url)
    }
}