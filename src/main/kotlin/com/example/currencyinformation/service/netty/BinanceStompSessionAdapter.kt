package com.example.currencyinformation.service.netty

import mu.KotlinLogging
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.stereotype.Component

@Component
internal class BinanceStompSessionAdapter : StompSessionHandlerAdapter() {

    private val logger = KotlinLogging.logger {}
    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        logger.info("received message: ${payload.toString()}")
    }

    override fun handleException(session: StompSession, command: StompCommand?, headers: StompHeaders, payload: ByteArray, exception: Throwable) {
        logger.error("encountered exception: $session, $command, $headers, $payload")
    }

    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        logger.info("connected to stream")
    }
}