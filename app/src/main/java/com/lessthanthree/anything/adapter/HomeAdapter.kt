package com.lessthanthree.anything.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lessthanthree.anything.R

class HomeAdapter(private val listName: ArrayList<String>,
                  private val listIcon: ArrayList<Int>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgIcon: ImageView = itemView.findViewById(R.id.img_item_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_view_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listIcon.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val icon = listIcon[position]

        Glide.with(holder.itemView.context)
            .load(icon)
            .apply(RequestOptions().override(150, 150))
            .into(holder.imgIcon)

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("title" to listName[position])
            val nav = when (position) {
                0 -> R.id.action_home_to_calculator
                1 -> R.id.action_nav_home_to_nav_notes
                5 -> R.id.action_home_to_counter
                else -> -1
            }
            if (nav != -1) {
                holder.itemView.findNavController()
                    .navigate(nav, bundle)
            } else {
                Toast.makeText(holder.itemView.context, "Coming Soon", Toast.LENGTH_SHORT).show()
            }
        }
    }

}