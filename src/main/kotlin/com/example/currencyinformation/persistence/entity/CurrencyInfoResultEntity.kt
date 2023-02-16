package com.example.currencyinformation.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.Instant

@Document("currencyInfoResult")
data class CurrencyInfoResultEntity(
        @Id
        val id: String,
        val eventType: String,
        val time: Instant,
        val symbol: String,
        val price: BigDecimal,
        val stream: String
)
