package com.example.androidlatihan16.viewmodel

import com.example.androidlatihan16.repo.AppException

class Resource<T> private constructor(
    val status: Resource.Status,
            val data: T?,
    val exception: AppException?){
    enum class Status{
        SUCCES, ERROR, LOADING
    }
    companion object {
        fun<T> succes(data : T?) : Resource<T>{
            return  Resource(Status.SUCCES, data, null)
        }
        fun<T> error(exception: AppException?) : Resource<T>{
            return  Resource(Status.ERROR, null, exception)
        }
        fun<T> loading(data : T?) : Resource<T>{
            return  Resource(Status.LOADING, data, null)
        }
    }
}