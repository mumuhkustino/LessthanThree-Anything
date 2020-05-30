package com.lessthanthree.anything.adapter

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Note
import java.text.DateFormat

class NotesListAdapter(var context: Context?) : RecyclerView.Adapter<NotesListAdapter.ListViewHolder>(){

    var listNotes : List<Note>

    init {
        listNotes = arrayListOf()
    }

    inner class ListViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var noteDate : TextView = itemView.findViewById(R.id.tvDateNoteList)
        var noteTitle : TextView = itemView.findViewById(R.id.tvTitleNoteList)
        var cardViewNoteList : CardView = itemView.findViewById(R.id.cv_notes_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_notes_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            var t = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55F,
                    context?.resources?.displayMetrics
                )
                    .toInt()
            if (holder.cardViewNoteList.layoutParams.height == t){
                holder.cardViewNoteList.layoutParams.height =
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250F,
                        context?.resources?.displayMetrics
                    )
                        .toInt()
                notifyDataSetChanged()
            } else {
                val bundle = bundleOf("title" to "Notes")
                val nav = R.id.action_nav_notes_list_to_nav_notes
                holder.itemView.findNavController()
                    .navigate(nav, bundle)
            }
        }

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