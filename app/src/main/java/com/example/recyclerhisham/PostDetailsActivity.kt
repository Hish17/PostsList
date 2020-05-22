package com.example.recyclerhisham

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.list_item_post.*
import kotlinx.android.synthetic.main.list_item_post.textName
import kotlinx.android.synthetic.main.list_item_post.textNumber

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: PostService = retrofit.create(PostService::class.java)

        var id: Int = intent.getIntExtra("haha", 0)

        val call = service.getPostById(id)
        progressDetails.visibility = View.VISIBLE

        call.enqueue(object : Callback<Post> {

            override fun onFailure(call: Call<Post>, t: Throwable) {
                progressDetails.visibility = View.GONE
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                progressDetails.visibility = View.GONE
                showBody(response.body())
            }

        })
    }

    private fun showBody(body: Post?) {
        if (body != null) {
            textName.text = body.title
        }
        if (body != null) {
            textNumber.text = body.body
        }
    }

}
