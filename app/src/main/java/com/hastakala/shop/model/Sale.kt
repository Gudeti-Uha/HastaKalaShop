package com.hastakala.shop.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val productName: String,
    val color: String,
    val quantity: Int,
    val pricePerUnit: Double,
    val timestamp: Long = System.currentTimeMillis()
) {
    val totalAmount: Double get() = quantity * pricePerUnit
}
