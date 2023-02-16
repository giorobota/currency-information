package com.example.currencyinformation.service.api.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class CurrencyInfoResultModel(
        @JsonProperty("e")
        val eventType: String,
        @JsonProperty("E")
        val time: Long,
        @JsonProperty("s")
        val symbol: String,
        @JsonProperty("p")
        val price: BigDecimal
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class CurrencyInfoResponse(
        val stream: String,
        val data: CurrencyInfoResultModel
)

