package com.hastakala.shop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.hastakala.shop.data.database.AppDatabase
import com.hastakala.shop.data.database.StockStat
import com.hastakala.shop.data.repository.SaleRepository
import com.hastakala.shop.model.Sale
import kotlinx.coroutines.launch
import java.util.Calendar

class SaleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SaleRepository = SaleRepository(AppDatabase.getDatabase(application))

    val allSales: LiveData<List<Sale>> = repository.allSales
    val totalRevenue: LiveData<Double?> = repository.totalRevenue
    val totalSalesCount: LiveData<Int> = repository.totalSalesCount
    val bestSellers = repository.bestSellers

    private val _filterMode = MutableLiveData<String>("all")
    val filterMode: LiveData<String> = _filterMode

    val filteredSales: LiveData<List<Sale>> = _filterMode.switchMap { mode ->
        when (mode) {
            "week" -> repository.getSalesThisWeek()
            "month" -> repository.getSalesThisMonth()
            else -> repository.allSales
        }
    }

    val filteredRevenue: LiveData<Double?> = _filterMode.switchMap { mode ->
        when (mode) {
            "week" -> {
                val cal = Calendar.getInstance()
                cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
                cal.set(Calendar.HOUR_OF_DAY, 0)
                cal.set(Calendar.MINUTE, 0)
                cal.set(Calendar.SECOND, 0)
                repository.getRevenueSince(cal.timeInMillis)
            }
            "month" -> {
                val cal = Calendar.getInstance()
                cal.set(Calendar.DAY_OF_MONTH, 1)
                cal.set(Calendar.HOUR_OF_DAY, 0)
                cal.set(Calendar.MINUTE, 0)
                cal.set(Calendar.SECOND, 0)
                repository.getRevenueSince(cal.timeInMillis)
            }
            else -> repository.totalRevenue
        }
    }

    private val _stockAlerts = MutableLiveData<List<StockStat>>()
    val stockAlerts: LiveData<List<StockStat>> = _stockAlerts

    private val _insertSuccess = MutableLiveData<Boolean>()
    val insertSuccess: LiveData<Boolean> = _insertSuccess

    fun setFilter(mode: String) {
        _filterMode.value = mode
    }

    fun insertSale(sale: Sale) {
        viewModelScope.launch {
            repository.insertSale(sale)
            _insertSuccess.postValue(true)
            refreshStockAlerts()
        }
    }

    fun deleteSale(sale: Sale) {
        viewModelScope.launch {
            repository.deleteSale(sale)
        }
    }

    fun refreshStockAlerts() {
        viewModelScope.launch {
            val stats = repository.getStockStats()
            val alerts = stats.filter { it.totalSold > 0 && it.totalSold % 5 == 0 }
            _stockAlerts.postValue(alerts)
        }
    }
}