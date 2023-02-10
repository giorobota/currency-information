package com.example.currencyinformation.logger

import com.example.currencyinformation.service.okhttp3.BINANCE_STREAM_URL
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.web.reactive.socket.client.WebSocketClient
import reactor.core.publisher.Mono
import java.net.URI

@Component
class ExchangeInfoWebSocketLogger(
        private val webSocketClient: WebSocketClient,
) : CommandLineRunner {

    private val logger = KotlinLogging.logger {}

    override fun run(vararg args: String?) {
        webSocketClient.execute(
                URI(BINANCE_STREAM_URL)
        ) { session ->
            session.receive()
                    .map(WebSocketMessage::getPayloadAsText)
                    .doOnNext {
                        logger.info { "received $it" }
                    }.then()
        }.block()
    }
}