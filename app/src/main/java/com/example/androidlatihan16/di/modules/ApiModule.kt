package com.example.androidlatihan16.di.modules

import com.example.androidlatihan16.api.Catalog
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesCatalogApi(retrofit : Retrofit) : Catalog{
        return retrofit.create<Catalog>(
            Catalog::class.java
        )
    }
}