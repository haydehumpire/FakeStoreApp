package com.reto.retoandroid.data.api

import com.reto.retoandroid.data.model.Product
import retrofit2.http.GET

interface FakeStoreApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}
