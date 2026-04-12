package com.example.expirytracker

data class ExpiryItem(
    val name: String,
    val status: String,
    val isExpired: Boolean,
    val category: String = "",
    val expiryDate: String = ""
)