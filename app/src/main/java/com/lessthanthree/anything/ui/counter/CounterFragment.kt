package com.lessthanthree.anything.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lessthanthree.anything.R
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment() {
    companion object {
        fun newInstance() = CounterFragment()
    }

    private lateinit var counterViewModel: CounterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        btnPlus.setOnClickListener {
            textViewCount.text = counterViewModel.increase().toString()
        }
        btnMinus.setOnClickListener {
            textViewCount.text = counterViewModel.decrease().toString()
        }
        btnReset.setOnClickListener {
            textViewCount.text = counterViewModel.reset().toString()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_search).isVisible = false
        super.onPrepareOptionsMenu(menu)
    }
}