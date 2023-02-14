package com.example.currencyinformation.service.okhttp3

import com.example.currencyinformation.service.api.CurrencyInformationWebSocketService
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener
import org.springframework.stereotype.Component

internal const val BINANCE_STREAM_URL =
        "wss://nbstream.binance.com/eoptions/stream?streams=BTC-210630-9000-P@trade/ETH@markPrice"

@Component
internal class CurrencyInformationWebSocketServiceImpl(
        private val listener: WebSocketListener
) : CurrencyInformationWebSocketService {
    private val client = OkHttpClient()

    override fun subscribeToSteam() {
        val request = Request.Builder().url(BINANCE_STREAM_URL).build()
        client.newWebSocket(request, listener)
    }
}