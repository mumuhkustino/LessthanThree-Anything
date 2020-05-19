package com.lessthanthree.anything.ui.calculator

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.lessthanthree.anything.R
import kotlinx.android.synthetic.main.fragment_calculator.*

class CalculatorFragment : Fragment() {

    companion object {
        fun newInstance() = CalculatorFragment()
    }

    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        // TODO: Use the ViewModel
        btnDivide.setOnClickListener {
            Toast.makeText(context, btnDivide.text.toString(), Toast.LENGTH_SHORT).show()
        }
        btnMultiply.setOnClickListener {
            Toast.makeText(context, btnMultiply.text.toString(), Toast.LENGTH_SHORT).show()
        }
        btnSubtraction.setOnClickListener {
            Toast.makeText(context, btnSubtraction.text.toString(), Toast.LENGTH_SHORT).show()
        }
        btnAddition.setOnClickListener {
            Toast.makeText(context, btnAddition.text.toString(), Toast.LENGTH_SHORT).show()
        }
        btnClear.setOnClickListener {
            Toast.makeText(context, btnClear.text.toString(), Toast.LENGTH_SHORT).show()
        }
        btnDelete.setOnClickListener {
            Toast.makeText(context, btnDelete.text.toString(), Toast.LENGTH_SHORT).show()
        }
        btnEqual.setOnClickListener {
            Toast.makeText(context, btnEqual.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_search).setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
}
