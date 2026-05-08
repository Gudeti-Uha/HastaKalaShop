package com.hastakala.shop.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hastakala.shop.model.Sale

@Database(entities = [Sale::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun saleDao(): SaleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hasta_kala_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
