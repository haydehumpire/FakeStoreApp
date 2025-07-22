package com.reto.retoandroid.repository

import com.reto.retoandroid.data.api.FakeStoreApi
import com.reto.retoandroid.data.db.ProductDao
import com.reto.retoandroid.data.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: FakeStoreApi,
    private val dao: ProductDao
) {
    val products: Flow<List<Product>> = dao.getAllProducts()

    suspend fun fetchAndStoreProducts() {
        val remoteProducts = api.getProducts()
        dao.clearAll()
        dao.insertAll(remoteProducts)
    }
}
