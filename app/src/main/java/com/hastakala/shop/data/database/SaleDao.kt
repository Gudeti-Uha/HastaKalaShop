package com.hastakala.shop.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hastakala.shop.model.Sale

@Dao
interface SaleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSale(sale: Sale): Long

    @Delete
    suspend fun deleteSale(sale: Sale)

    @Query("SELECT * FROM sales ORDER BY timestamp DESC")
    fun getAllSales(): LiveData<List<Sale>>

    @Query("SELECT * FROM sales ORDER BY timestamp DESC")
    suspend fun getAllSalesOnce(): List<Sale>

    @Query("SELECT * FROM sales WHERE timestamp >= :startTime ORDER BY timestamp DESC")
    fun getSalesSince(startTime: Long): LiveData<List<Sale>>

    @Query("SELECT * FROM sales WHERE timestamp >= :startTime ORDER BY timestamp DESC")
    suspend fun getSalesSinceOnce(startTime: Long): List<Sale>

    @Query("SELECT SUM(pricePerUnit * quantity) FROM sales WHERE timestamp >= :startTime")
    fun getTotalRevenueSince(startTime: Long): LiveData<Double?>

    @Query("SELECT SUM(pricePerUnit * quantity) FROM sales")
    fun getTotalRevenue(): LiveData<Double?>

    @Query("SELECT COUNT(*) FROM sales")
    fun getTotalSalesCount(): LiveData<Int>

    // Stock queries - get current quantity per product+color
    @Query("""
        SELECT productName || ' (' || color || ')' as label,
               SUM(quantity) as totalSold
        FROM sales
        GROUP BY productName, color
        ORDER BY totalSold DESC
    """)
    fun getBestSellers(): LiveData<List<ProductColorStat>>

    @Query("""
        SELECT productName, color, SUM(quantity) as totalSold
        FROM sales
        GROUP BY productName, color
    """)
    suspend fun getStockStats(): List<StockStat>
}

data class ProductColorStat(
    val label: String,
    val totalSold: Int
)

data class StockStat(
    val productName: String,
    val color: String,
    val totalSold: Int
)
