package com.example.recyclerhisham

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    fun getPostsList(): Call<List<Post>>

    @GET("posts/{postId}")
    fun getPostById(@Path("postId") postId: Int): Call<Post>


}