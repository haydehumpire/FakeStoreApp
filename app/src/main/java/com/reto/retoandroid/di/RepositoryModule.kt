package com.reto.retoandroid.di

import com.reto.retoandroid.data.api.FakeStoreApi
import com.reto.retoandroid.data.db.ProductDao
import com.reto.retoandroid.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        api: FakeStoreApi,
        dao: ProductDao
    ): ProductRepository {
        return ProductRepository(api, dao)
    }
}
