package com.lessthanthree.anything.ui.notes

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.airbnb.paris.Paris
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Note
import kotlinx.android.synthetic.main.fragment_notes.*
import java.util.*

class NotesFragment : Fragment() {

    companion object {
        fun newInstance() = NotesFragment()
    }

    private lateinit var viewModel: NotesViewModel
    private var colorMode: Int = 0
    private lateinit var sharedPreferences: SharedPreferences

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
        sharedPreferences = requireContext().getSharedPreferences(getString(R.string.color_mode), Context.MODE_PRIVATE)

        colorMode = sharedPreferences.getInt(getString(R.string.color_mode), 0)
        when (colorMode) {
            1 -> {
                Paris.style(mainLayout).apply(R.style.NoteStyleLightBlue)
                Paris.style(notesMenu).apply(R.style.NoteStyleLightBlue)
                Paris.style(notesMoreMenu).apply(R.style.NoteStyleLightBlue)
            }
            2 -> {
                Paris.style(mainLayout).apply(R.style.NoteStyleYellow)
                Paris.style(notesMenu).apply(R.style.NoteStyleYellow)
                Paris.style(notesMoreMenu).apply(R.style.NoteStyleYellow)
            }
            0 -> {
                Paris.style(mainLayout).apply(R.style.NoteStyleWhite)
                Paris.style(notesMenu).apply(R.style.NoteStyleWhite)
                Paris.style(notesMoreMenu).apply(R.style.NoteStyleWhite)
            }
        }

        viewModel.allNotes.observe(viewLifecycleOwner,
            Observer { t ->
                if (t != null && t.size != 0) {
                    if (arguments?.getParcelable<Note>("note") != null){
                        note = arguments?.getParcelable("note")
                        Log.d("notesfragment","Bundle " + note.toString())
                    } else {
                        note = t[t.size - 1]
                    }
//                    for (i in t.indices) {
//                        Log.d("", "Note " + i.toString() + " " + t[i].toString())
//                    }
                } else {
                    note = Note( "", Date())
                    viewModel.insert(note!!)
                }
                if (!edit && note != null) {
                    editNote.text = Editable.Factory.getInstance().newEditable(note!!.description)
                    edit = true
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
            note = Note("", Date())
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

                val builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogNotes))
                val positiveButtonClick = { dialog: DialogInterface, which: Int ->
                    Toast.makeText(context,
                        android.R.string.no, Toast.LENGTH_SHORT).show()

                }
//                val negativeButtonClick = { dialog: DialogInterface, which: Int ->
//                    Toast.makeText(context,
//                        android.R.string.no, Toast.LENGTH_SHORT).show()
//                }

                val neutralButtonClick = { dialog: DialogInterface, which: Int ->
                    Toast.makeText(context,android.R.string.yes, Toast.LENGTH_SHORT).show()
                    note?.let { it1 -> viewModel.delete(it1) }
                    edit = false
                    notesMenu.visibility = View.VISIBLE
                    notesMoreMenu.visibility = View.GONE
                    coverView.visibility = View.GONE
                }

                with(builder)
                {
                    setMessage("Are You Sure")
                    setNeutralButton("Yes", DialogInterface.OnClickListener(function = neutralButtonClick))
                    setPositiveButton("No", DialogInterface.OnClickListener(function = positiveButtonClick))
                    show()
                }
        }

        btnColor.setOnClickListener {
            when (colorMode) {
                0 -> {
                    Paris.style(mainLayout).apply(R.style.NoteStyleLightBlue)
                    Paris.style(notesMenu).apply(R.style.NoteStyleLightBlue)
                    Paris.style(notesMoreMenu).apply(R.style.NoteStyleLightBlue)
                    colorMode = 1
                    sharedPreferences.edit().putInt(getString(R.string.color_mode), colorMode).apply()
                }
                1 -> {
                    Paris.style(mainLayout).apply(R.style.NoteStyleYellow)
                    Paris.style(notesMenu).apply(R.style.NoteStyleYellow)
                    Paris.style(notesMoreMenu).apply(R.style.NoteStyleYellow)
                    colorMode = 2
                    sharedPreferences.edit().putInt(getString(R.string.color_mode), colorMode).apply()
                }
                2 -> {
                    Paris.style(mainLayout).apply(R.style.NoteStyleWhite)
                    Paris.style(notesMenu).apply(R.style.NoteStyleWhite)
                    Paris.style(notesMoreMenu).apply(R.style.NoteStyleWhite)
                    colorMode = 0
                    sharedPreferences.edit().putInt(getString(R.string.color_mode), colorMode).apply()
                }
            }
        }

    }
}