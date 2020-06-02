package com.lessthanthree.anything.adapter

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Note
import java.text.DateFormat

class NotesListAdapter(var context: Context?) : RecyclerView.Adapter<NotesListAdapter.ListViewHolder>(){

    var listNotes : List<Note>
    var viewPos = -1
    private lateinit var onItemClickCallback: OnItemClickCallback

    init {
        listNotes = arrayListOf()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
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
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(position) }

        val note = listNotes.get(position)
        val date = note.date

        holder.noteDate.text = DateFormat.getDateInstance().format(date)
        holder.noteTitle.text = note.description
    }

    internal fun setNotes(notes : List<Note>){
        this.listNotes = notes
        notifyDataSetChanged()
    }

    fun changeHeight (pos: Int, rvNotes: RecyclerView){
        val holder = rvNotes.findViewHolderForAdapterPosition(pos) as RecyclerView.ViewHolder
        val t = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55F,
                    context?.resources?.displayMetrics
                ).toInt()

        if (viewPos != -1 && viewPos != pos){
            val holderAnother = rvNotes.findViewHolderForAdapterPosition(viewPos) as RecyclerView.ViewHolder
            holderAnother.itemView.findViewById<View>(R.id.cv_notes_list).layoutParams.height = t
        }

        if (holder.itemView.layoutParams.height == t){
            holder.itemView.layoutParams.height =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250F,
                    context?.resources?.displayMetrics
                ).toInt()
            viewPos = pos
        } else {
            val bundle = bundleOf("title" to "Notes")
            bundle.putParcelable("note", listNotes[pos])
            val nav = R.id.action_nav_notes_list_to_nav_notes
            holder.itemView.findNavController().navigate(nav, bundle)
        }
        notifyDataSetChanged()
    }

    interface OnItemClickCallback {
        fun onItemClicked(position: Int)
    }
}