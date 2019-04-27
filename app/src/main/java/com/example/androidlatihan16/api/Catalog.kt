package com.example.androidlatihan16.api

import com.example.androidlatihan16.data.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Catalog {
    @GET("catalog/v4/search")
    fun search(@Query("q") q: String,
               @Query("limit") limit: Int = 10,
               @Query("offset") offset: Int = 0)
            :Call<SearchResponse>
}