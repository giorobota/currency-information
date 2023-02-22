package com.example.currencyinformation.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "logging-config")
data class LoggingConfiguration(
        val requestLoggerEnabled: Boolean,
        val okhttpLoggerEnabled: Boolean,
        val websocketLoggerEnabled: Boolean,
)
