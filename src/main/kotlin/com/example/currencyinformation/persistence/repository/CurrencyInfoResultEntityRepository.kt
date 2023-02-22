package com.example.currencyinformation.persistence.repository

import com.example.currencyinformation.persistence.entity.CurrencyConfig
import com.example.currencyinformation.persistence.entity.CurrencyInfoResultEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
internal interface CurrencyInfoResultEntityRepository: MongoRepository<CurrencyInfoResultEntity, String> {

}