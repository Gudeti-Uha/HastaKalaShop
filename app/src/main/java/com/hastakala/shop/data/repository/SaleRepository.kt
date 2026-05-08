package com.hastakala.shop.data.repository

import androidx.lifecycle.LiveData
import com.hastakala.shop.data.database.AppDatabase
import com.hastakala.shop.data.database.ProductColorStat
import com.hastakala.shop.data.database.StockStat
import com.hastakala.shop.model.Sale
import java.util.Calendar

class SaleRepository(database: AppDatabase) {

    private val saleDao = database.saleDao()

    val allSales: LiveData<List<Sale>> = saleDao.getAllSales()
    val totalRevenue: LiveData<Double?> = saleDao.getTotalRevenue()
    val totalSalesCount: LiveData<Int> = saleDao.getTotalSalesCount()
    val bestSellers: LiveData<List<ProductColorStat>> = saleDao.getBestSellers()

    suspend fun insertSale(sale: Sale) = saleDao.insertSale(sale)
    suspend fun deleteSale(sale: Sale) = saleDao.deleteSale(sale)

    fun getSalesThisWeek(): LiveData<List<Sale>> {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        return saleDao.getSalesSince(cal.timeInMillis)
    }

    fun getSalesThisMonth(): LiveData<List<Sale>> {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        return saleDao.getSalesSince(cal.timeInMillis)
    }

    fun getRevenueSince(startTime: Long): LiveData<Double?> =
        saleDao.getTotalRevenueSince(startTime)

    suspend fun getStockStats(): List<StockStat> = saleDao.getStockStats()

    suspend fun getAllSalesOnce(): List<Sale> = saleDao.getAllSalesOnce()
}
