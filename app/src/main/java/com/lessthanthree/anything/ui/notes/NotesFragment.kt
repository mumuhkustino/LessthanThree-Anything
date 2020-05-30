package com.lessthanthree.anything.ui.notes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Note
import kotlinx.android.synthetic.main.fragment_notes.*
import java.util.*


class NotesFragment : Fragment() {

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        var note: Note? = null
        var edit = false

        viewModel.allNotes.observe(viewLifecycleOwner,
            Observer { t ->
                if (t != null && t.size != 0) {
                    note = t.get(t.size - 1)
                    for (i in t.indices) {
                        Log.d("", "Note " + i.toString() + " " + t[i].toString())
                    }
                } else {
                    note = Note("", "", Date())
                    viewModel.insert(note!!)
                }
                if (!edit && note != null) {
                    editTitle.text = Editable.Factory.getInstance().newEditable(note!!.title)
                    editNote.text = Editable.Factory.getInstance().newEditable(note!!.description)
                    edit = true
                }
            })

        editTitle.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                if (note?.title != s.toString()) {
                    note?.title = s.toString()
                    note?.date = Date()
                    note?.let { viewModel.update(it) }
                }
            }
        })

        editNote.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                if (note?.description != s.toString()) {
                    note?.description = s.toString()
                    note?.date = Date()
                    note?.let { viewModel.update(it) }
                }
            }
        })

        btnNew.setOnClickListener {
            note = Note("", "", Date())
            editTitle.text = Editable.Factory.getInstance().newEditable(note!!.title)
            editNote.text = Editable.Factory.getInstance().newEditable(note!!.description)
            viewModel.insert(note!!)
        }

        btnMore.setOnClickListener {
            notesMenu.visibility = View.GONE
            notesMoreMenu.visibility = View.VISIBLE
            coverView.visibility = View.VISIBLE
        }

        coverView.setOnClickListener {
            if(notesMoreMenu.isShown) {
                notesMenu.visibility = View.VISIBLE
                notesMoreMenu.visibility = View.GONE
            }
            coverView.visibility = View.GONE
        }

        btnNotesList.setOnClickListener {
            val bundle = bundleOf("title" to getString(R.string.notes_list))
            findNavController().navigate(R.id.action_nav_notes_to_nav_notes_list, bundle)
        }

        btnDeleteNote.setOnClickListener {
            note?.let { it1 -> viewModel.delete(it1) }
            edit = false
            notesMenu.visibility = View.VISIBLE
            notesMoreMenu.visibility = View.GONE
            coverView.visibility = View.GONE
        }
    }

}