package com.lessthanthree.anything.ui.notes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Note
import kotlinx.android.synthetic.main.fragment_notes.*
import java.util.Date

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
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        var idNote = 0
        var note: Note? = null
        var edit = false

        viewModel.allNotes.observe(viewLifecycleOwner, object : Observer<List<Note>> {
            override fun onChanged(t: List<Note>?) {
                if (t != null && t.size != 0) {
                    Log.d("SIZE: ", t.size.toString())
                    idNote = t.size - 1
                    note = t.get(idNote)
                    Log.d("FIRST: ", note.toString())
                    for (i in t.indices) {
                        Log.d("T: ", i.toString() + " " + t.get(i).toString())
                    }
                } else {
                    Log.d("SECOND: ", note.toString())
                    viewModel.insert(note = Note("", "", Date()))
                }
                if (!edit && note != null) {
                    editTitle.text = Editable.Factory.getInstance().newEditable(note?.title)
                    editNote.text = Editable.Factory.getInstance().newEditable(note?.description)
                    edit = true
                }
            }
        })

        btnNew.setOnClickListener() {
            // TODO: save note, new note page
//            viewModel.insert(note = Note(editTitle.text.toString(), editNote.text.toString(), Date()))
            viewModel.insert(note = Note("", "", Date()))
            blank()
        }

        tvId.text = idNote.toString()
        Log.d("", "" + idNote)

        editTitle.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                note?.title = s.toString()
                note?.date = Date()
                Log.d("TITLE: ", note.toString())
                note?.let { viewModel.update(it) }
            }
        })

        editNote.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                note?.description = s.toString()
                note?.date = Date()
                Log.d("DESC: ", note.toString())
                note?.let { viewModel.update(it) }
            }
        })
    }

    fun blank() {
        editTitle.requestFocus()
        editTitle.text = Editable.Factory.getInstance().newEditable("")
        editNote.text = Editable.Factory.getInstance().newEditable("")
    }


}