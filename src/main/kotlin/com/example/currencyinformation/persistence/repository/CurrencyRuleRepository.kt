package com.example.currencyinformation.persistence.repository

import com.example.currencyinformation.persistence.entity.CurrencyRule
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
internal interface CurrencyRuleRepository : MongoRepository<CurrencyRule, String>