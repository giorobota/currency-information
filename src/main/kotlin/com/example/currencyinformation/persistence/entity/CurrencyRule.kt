package com.example.currencyinformation.persistence.entity


data class CurrencyRule(
        val channel: String,
        val isEnabled: Boolean,
        val streamName: String,
        val streamType: String,
)
