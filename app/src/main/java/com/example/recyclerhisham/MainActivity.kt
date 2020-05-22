package com.example.recyclerhisham

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var postsAdapter: PostsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerViewContacts.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: PostService = retrofit.create(PostService::class.java)

        val call = service.getPostsList()

        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                showData(response.body()!!)
            }

        })
    }


    private fun showData(body: List<Post>) {
        postsAdapter = PostsAdapter(body, object : OnItemClickListener {
            override fun onItemClick(view: View, id: Int) {
                val intent = Intent(this@MainActivity, PostDetailsActivity::class.java)
                intent.putExtra("haha", id)
                startActivity(intent)
            }

            override fun onItemLongClick(view: View?, position: Int) {

            }
        })
        RecyclerViewContacts.adapter = postsAdapter
    }
}


