package com.example.currencyinformation.service.okhttp3

import mu.KotlinLogging
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import org.springframework.stereotype.Component

@Component
internal class BinanceWebSocketListener : WebSocketListener() {

    private val logger = KotlinLogging.logger {}
    override fun onMessage(webSocket: WebSocket, text: String) {
        logger.info("received message: $text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        logger.info("received message: $bytes")
    }
}