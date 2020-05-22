package com.example.recyclerhisham

import android.view.View

interface OnItemClickListener {

    fun onItemClick(view: View, id: Int)
    fun onItemLongClick(view: View?, position: Int)
}