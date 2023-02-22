package com.example.currencyinformation.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("currencyConfig")
data class CurrencyConfig(

        @Id
        val name: String,

        val percent: Int,

        val isEnabled: Boolean,

        val rules: List<CurrencyRule>
)
