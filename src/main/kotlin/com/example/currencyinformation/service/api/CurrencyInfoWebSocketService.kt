package com.example.currencyinformation.service.api

import reactor.core.publisher.Mono

interface CurrencyInfoWebSocketService {
    fun subscribeToStreams(streamNames: List<String>): Mono<Void>

}