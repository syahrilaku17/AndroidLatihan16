package com.example.androidlatihan16.di.modules

import com.example.androidlatihan16.api.Catalog
import com.example.androidlatihan16.repo.CatalogRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideCatalogRepo(api: Catalog):CatalogRepository{
        return CatalogRepository(api)
    }
}