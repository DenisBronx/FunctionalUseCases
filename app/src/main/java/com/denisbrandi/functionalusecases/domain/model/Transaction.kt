package com.denisbrandi.functionalusecases.domain.model

data class Transaction(
    val id: String,
    val amount: Double,
    val recipientId: String,
    val transactionDate: Long
)