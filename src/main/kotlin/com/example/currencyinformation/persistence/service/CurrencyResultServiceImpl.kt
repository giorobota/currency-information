package com.example.currencyinformation.persistence.service

import com.example.currencyinformation.persistence.entity.CurrencyInfoResultEntity
import com.example.currencyinformation.persistence.repository.CurrencyInfoResultEntityRepository
import com.example.currencyinformation.persistence.service.api.CurrencyResultService
import com.example.currencyinformation.service.api.model.CurrencyInfoResponse
import org.springframework.stereotype.Component
import java.time.Instant


@Component
internal class CurrencyResultServiceImpl(
        private val repository: CurrencyInfoResultEntityRepository
) : CurrencyResultService {

    override fun saveResponse(response: CurrencyInfoResponse) {
        val entity = response.toEntity()
        repository.save(entity)
    }

    private fun CurrencyInfoResponse.toEntity(): CurrencyInfoResultEntity =
            CurrencyInfoResultEntity(
                    id = "${data.time}${data.symbol}",
                    price = data.price,
                    eventType = data.eventType,
                    symbol = data.symbol,
                    time = Instant.ofEpochMilli(data.time),
                    stream = stream
            )
}