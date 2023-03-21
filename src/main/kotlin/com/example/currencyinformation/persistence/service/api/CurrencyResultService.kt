package com.example.currencyinformation.persistence.service.api

import com.example.currencyinformation.service.api.model.CurrencyInfoResponse

interface CurrencyResultService {
    fun saveResponse(response: CurrencyInfoResponse)
}