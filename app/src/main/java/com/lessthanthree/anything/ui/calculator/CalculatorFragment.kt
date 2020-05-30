package com.lessthanthree.anything.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
        // TODO: Use the ViewModel

        //operator
        btnDivide.setOnClickListener {
            Toast.makeText(context, btnDivide.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("/")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnMultiply.setOnClickListener {
            Toast.makeText(context, btnMultiply.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("*")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnSubtraction.setOnClickListener {
            Toast.makeText(context, btnSubtraction.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("-")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnAddition.setOnClickListener {
            Toast.makeText(context, btnAddition.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("+")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnClear.setOnClickListener {
            Toast.makeText(context, btnClear.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.clear()
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnDelete.setOnClickListener {
            Toast.makeText(context, btnDelete.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.delete()
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnEqual.setOnClickListener {
            Toast.makeText(context, btnEqual.text.toString(), Toast.LENGTH_SHORT).show()
            textViewResult.text = calculatorViewModel.calculate()
        }

        //number
        btnNum0.setOnClickListener {
            Toast.makeText(context, btnNum0.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("0")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum00.setOnClickListener {
            Toast.makeText(context, btnNum00.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("00")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum1.setOnClickListener {
            Toast.makeText(context, btnNum1.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("1")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum2.setOnClickListener {
            Toast.makeText(context, btnNum2.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("2")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum3.setOnClickListener {
            Toast.makeText(context, btnNum3.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("3")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum4.setOnClickListener {
            Toast.makeText(context, btnNum4.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("4")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum5.setOnClickListener {
            Toast.makeText(context, btnNum5.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("5")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum6.setOnClickListener {
            Toast.makeText(context, btnNum6.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("6")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum7.setOnClickListener {
            Toast.makeText(context, btnNum7.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("7")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum8.setOnClickListener {
            Toast.makeText(context, btnNum8.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("8")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNum9.setOnClickListener {
            Toast.makeText(context, btnNum9.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression("9")
            textViewResult.text = calculatorViewModel.getExpression()
        }
        btnNumPoint.setOnClickListener {
            Toast.makeText(context, btnNumPoint.text.toString(), Toast.LENGTH_SHORT).show()
            calculatorViewModel.evaluateExpression(".")
            textViewResult.text = calculatorViewModel.getExpression()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.action_search).isVisible = false
        super.onPrepareOptionsMenu(menu)
    }
}
