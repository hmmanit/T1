package com.homanad.android.t1.ui.feature.home.page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homanad.android.t1.R
import com.homanad.android.t1.ui.feature.home.page.type.Page

class HomeSlidingAdapter : RecyclerView.Adapter<HomeSlidingAdapter.ItemHolder>() {

    val pages = listOf(
        Page.TASKS, Page.BOARDS, Page.OTHERS
    )

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sliding_home, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return pages.size
    }
}