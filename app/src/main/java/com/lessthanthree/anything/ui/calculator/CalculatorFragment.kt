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
            calculatorViewModel.divide()
            textViewResult.text = btnDivide.text.toString()
        }
        btnMultiply.setOnClickListener {
            Toast.makeText(context, btnMultiply.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.multiply()
            textViewResult.text = btnMultiply.text.toString()
        }
        btnSubtraction.setOnClickListener {
            Toast.makeText(context, btnSubtraction.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.subtraction()
            textViewResult.text = btnSubtraction.text.toString()
        }
        btnAddition.setOnClickListener {
            Toast.makeText(context, btnAddition.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.addition()
            textViewResult.text = btnAddition.text.toString()
        }
        btnClear.setOnClickListener {
            Toast.makeText(context, btnClear.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.clear()
            textViewResult.text = btnClear.text.toString()
        }
        btnDelete.setOnClickListener {
            Toast.makeText(context, btnDelete.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.delete()
            textViewResult.text = btnDelete.text.toString()
        }
        btnEqual.setOnClickListener {
            Toast.makeText(context, btnEqual.text.toString(), Toast.LENGTH_SHORT).show()
            textViewResult.text = calculatorViewModel.calculate()
        }
        btnNum0.setOnClickListener {
            Toast.makeText(context, btnNum0.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum0.text.toString())
            textViewResult.text = btnNum0.text.toString()
        }
        btnNum00.setOnClickListener {
            Toast.makeText(context, btnNum00.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum00.text.toString())
            textViewResult.text = btnNum00.text.toString()
        }
        btnNum1.setOnClickListener {
            Toast.makeText(context, btnNum1.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum1.text.toString())
            textViewResult.text = btnNum1.text.toString()
        }
        btnNum2.setOnClickListener {
            Toast.makeText(context, btnNum2.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum2.text.toString())
            textViewResult.text = btnNum2.text.toString()
        }
        btnNum3.setOnClickListener {
            Toast.makeText(context, btnNum3.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum3.text.toString())
            textViewResult.text = btnNum3.text.toString()
        }
        btnNum4.setOnClickListener {
            Toast.makeText(context, btnNum4.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum4.text.toString())
            textViewResult.text = btnNum4.text.toString()
        }
        btnNum5.setOnClickListener {
            Toast.makeText(context, btnNum5.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum5.text.toString())
            textViewResult.text = btnNum5.text.toString()
        }
        btnNum6.setOnClickListener {
            Toast.makeText(context, btnNum6.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum6.text.toString())
            textViewResult.text = btnNum6.text.toString()
        }
        btnNum7.setOnClickListener {
            Toast.makeText(context, btnNum7.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum7.text.toString())
            textViewResult.text = btnNum7.text.toString()
        }
        btnNum8.setOnClickListener {
            Toast.makeText(context, btnNum8.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum8.text.toString())
            textViewResult.text = btnNum8.text.toString()
        }
        btnNum9.setOnClickListener {
            Toast.makeText(context, btnNum9.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNum9.text.toString())
            textViewResult.text = btnNum9.text.toString()
        }
        btnNumPoint.setOnClickListener {
            Toast.makeText(context, btnNumPoint.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.setOperand(btnNumPoint.text.toString())
            textViewResult.text = btnNumPoint.text.toString()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_search).setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
}
