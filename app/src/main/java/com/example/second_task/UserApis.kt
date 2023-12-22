package com.example.second_task

import retrofit2.Call
import retrofit2.http.GET

interface UserApis {
    @GET("products")
    fun GetProductById(): Call<List<Product>>
}