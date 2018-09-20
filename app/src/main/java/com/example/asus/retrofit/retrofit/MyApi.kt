package com.example.asus.retrofit.retrofit

import com.example.asus.retrofit.model.Post
import io.reactivex.Observable
import retrofit2.http.GET


interface MyApi{

        @get:GET("posts")
        val posts: Observable<List<Post>>

    }

