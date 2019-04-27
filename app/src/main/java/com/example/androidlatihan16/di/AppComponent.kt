package com.example.androidlatihan16.di

import android.app.Application
import android.content.Context
import com.example.androidlatihan16.di.modules.ApiModule
import com.example.androidlatihan16.di.modules.AppModule
import com.example.androidlatihan16.di.modules.NetModule
import com.example.androidlatihan16.di.modules.RepositoryModule
import com.example.androidlatihan16.repo.CatalogRepository
import com.example.androidlatihan16.viewmodel.ProductViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(

    modules = arrayOf(ApiModule::class, NetModule::class, RepositoryModule::class, AppModule::class)
)
interface AppComponent {
    fun inject(viewModelModule: ProductViewModel)
    fun inject(activity : Context)

    fun provideCatalogRepository() : CatalogRepository

    companion object Factory{
        fun create(app: Application, baseUrl : String) : AppComponent{
            val appComponent = DaggerAppComponent.builder().appModule(AppModule(app))
                .apiModule(ApiModule())
                .netModule(NetModule(baseUrl))
                .repositoryModule(RepositoryModule())
                .build()
            return appComponent
        }
    }
}