package com.lessthanthree.anything.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lessthanthree.anything.R

class HomeAdapter(private val listIcon: ArrayList<Int>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgIcon: ImageView = itemView.findViewById(R.id.img_item_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listIcon.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val icon = listIcon[position]

        Glide.with(holder.itemView.context)
            .load(icon)
            .apply(RequestOptions().override(200, 200))
            .into(holder.imgIcon)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "clicked", Toast.LENGTH_SHORT).show()
        }
    }

}