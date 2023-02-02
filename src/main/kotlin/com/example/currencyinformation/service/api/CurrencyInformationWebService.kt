package com.example.currencyinformation.service.api

import com.fasterxml.jackson.databind.JsonNode

interface CurrencyInformationWebService {

    fun ping()


    fun exchangeInfo(): JsonNode
}