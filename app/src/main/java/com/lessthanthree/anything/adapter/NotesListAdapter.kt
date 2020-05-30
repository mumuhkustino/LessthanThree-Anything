package com.lessthanthree.anything.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Note
import java.text.DateFormat

class NotesListAdapter : RecyclerView.Adapter<NotesListAdapter.ListViewHolder>(){

    var listNotes : List<Note>

    init {
        listNotes = arrayListOf()

    }

    inner class ListViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var noteDate : TextView = itemView.findViewById(R.id.tvDateNoteList)
        var noteTitle : TextView = itemView.findViewById(R.id.tvTitleNoteList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_notes_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("adapter ", "" + listNotes.size)
        return listNotes.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "tester", Toast.LENGTH_SHORT).show()
        }

        Log.d("adapter ", "" + listNotes[position].toString())

        var note = listNotes.get(position)
        var date = note.date

        holder.noteDate.text = DateFormat.getDateInstance().format(date)
        holder.noteTitle.text = note.description
    }

    internal fun setNotes(notes : List<Note>){
        this.listNotes = notes
        notifyDataSetChanged()
    }
}