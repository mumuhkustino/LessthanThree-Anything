package com.lessthanthree.anything.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.lessthanthree.anything.R
import com.lessthanthree.anything.model.Counter
import kotlinx.android.synthetic.main.fragment_calculator.*
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
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

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
        menu.findItem(R.id.action_search).setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
}