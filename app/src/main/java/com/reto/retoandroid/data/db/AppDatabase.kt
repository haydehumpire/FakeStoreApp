package com.reto.retoandroid.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.reto.retoandroid.data.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
