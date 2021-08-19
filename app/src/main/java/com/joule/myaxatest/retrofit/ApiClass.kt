package com.joule.myaxatest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClass {
    companion object {
        fun retrofit(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}