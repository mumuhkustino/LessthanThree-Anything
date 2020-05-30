package com.lessthanthree.anything.ui.notes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.lessthanthree.anything.R
import com.lessthanthree.anything.adapter.NotesListAdapter
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notesListAdapter = NotesListAdapter(context)

        rvNotes.setHasFixedSize(true)
        rvNotes.layoutManager = LinearLayoutManager(context)
        rvNotes.adapter = notesListAdapter

        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        viewModel.allNotes.observe(viewLifecycleOwner,
            Observer { list ->
                notesListAdapter.setNotes(list)
                for(i in list.indices) {
                    Log.d("fragment : ", "" + list[i].toString())
                }
            })

    }

}
