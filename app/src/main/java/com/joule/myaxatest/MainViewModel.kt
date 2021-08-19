package com.joule.myaxatest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joule.myaxatest.retrofit.ApiClass
import com.joule.myaxatest.retrofit.ApiGet
import com.joule.myaxatest.dataClass.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val _post = MutableLiveData<ArrayList<Post>>()
    val post : LiveData<ArrayList<Post>> = _post

    val _postByPage = MutableLiveData<ArrayList<Post>>()
    val postByPage : LiveData<ArrayList<Post>> = _postByPage


    fun getPost(){
        val retrofit = ApiClass.retrofit().create(ApiGet::class.java)
        val call = retrofit.getPost()
        call.enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                response.body()?.let { _post.postValue(response.body())}
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                Log.d("yy", "onFailure: ${t.message}")
            }
        })
    }

    fun getPostByPage(page: Int, data: ArrayList<Post>){
        var result : ArrayList<Post> = ArrayList()
        for (i in 0 until data.size){
            if (data.get(i).userId == page){
                result.add(data.get(i))
            }
        }

        _postByPage.postValue(result)
    }
}