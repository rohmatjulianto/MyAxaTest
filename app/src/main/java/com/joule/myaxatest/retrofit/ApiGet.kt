package com.joule.myaxatest.retrofit

import com.joule.myaxatest.dataClass.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiGet {
    @GET("posts")
    fun getPost() : Call<ArrayList<Post>>
}