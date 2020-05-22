package com.example.recyclerhisham

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_post.view.*

class PostsAdapter(
    private val contactsList: List<Post>,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

//        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_post, parent, false) as ViewGroup

        return MyViewHolder(View)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.textName.text = contactsList[position].title
        holder.view.textNumber.text = contactsList[position].body
        holder.view.setOnClickListener {
            onItemClickListener.onItemClick(it, contactsList[position].id)
        }
    }

    override fun getItemCount() = contactsList.size
}