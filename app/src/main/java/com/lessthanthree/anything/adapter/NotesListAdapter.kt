package com.lessthanthree.anything.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lessthanthree.anything.R
import kotlinx.android.synthetic.main.item_notes_list.view.*

class NotesListAdapter : RecyclerView.Adapter<NotesListAdapter.ListViewHolder>() {
    inner class ListViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        var date : TextView = itemView.findViewById(R.id.tvDateNoteList)
        var noteTitle : TextView = itemView.findViewById(R.id.tvTitleNoteList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_notes_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "tester", Toast.LENGTH_SHORT).show()
        }
    }
}