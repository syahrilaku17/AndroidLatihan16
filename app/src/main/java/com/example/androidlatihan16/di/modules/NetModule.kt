package com.example.androidlatihan16.di.modules

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetModule( val baseurl:String) {
    val QUERY_PARAMETER = "apikey"
    val KEY = "3E7F9D369D534E4593F604C00089B20B"

    @Provides
    @Singleton
    fun  provideHttpCache(application: Application) : Cache{
        val cacheSize = 10 * 1024 * 1024L
        val  cache = Cache(application.cacheDir, cacheSize)
        return cache
    }

    @Provides
    @Singleton
    fun provideGSON() : Gson{
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(
            FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
        )
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: Interceptor) : OkHttpClient{
        val client = OkHttpClient.Builder().addInterceptor(interceptor)
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson : Gson, okhttp : OkHttpClient):Retrofit{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseurl)
            .client(okhttp)
            .build()
    }

    @Provides
    @Singleton
    fun  provideInterceptor(): Interceptor{
        return Interceptor{
            chain ->

            val url = chain.request().url().newBuilder().addQueryParameter(QUERY_PARAMETER,KEY)
                .addQueryParameter("format", "json")
                .build()

            val request = chain.request().newBuilder().url(url).build()

            chain.proceed(request)
        }
    }
}