package com.lessthanthree.anything.ui.notes

import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.lessthanthree.anything.MainActivity
import com.lessthanthree.anything.R
import kotlinx.android.synthetic.main.fragment_notes.*


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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        btnNew.setOnClickListener() {
            // TODO: save note, new note page
        }

        btnMore.setOnClickListener() {
            notesMenu.visibility = View.GONE
            notesMoreMenu.visibility = View.VISIBLE
        }

    }
}