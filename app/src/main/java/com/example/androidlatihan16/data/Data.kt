package com.example.androidlatihan16.data

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Product(val id: String,
                   val tittle: String = "",
                   val images:List<Image> = ArrayList(),
                   val longDescription: String = "",
                   val shortDescription: String = ""

                   )
data class Image(@SerializedName("key")
                val size : String = "M",
                 @SerializedName("url")
                 val url : String = "")

data class SearchResponse(val product: List<Product> = ArrayList())