package com.example.fixcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.Button_add
import kotlinx.android.synthetic.main.activity_main.Button_bracket_left
import kotlinx.android.synthetic.main.activity_main.Button_bracket_right
import kotlinx.android.synthetic.main.activity_main.Button_clear
import kotlinx.android.synthetic.main.activity_main.Button_divide
import kotlinx.android.synthetic.main.activity_main.Button_dot
import kotlinx.android.synthetic.main.activity_main.Button_eight
import kotlinx.android.synthetic.main.activity_main.Button_equal
import kotlinx.android.synthetic.main.activity_main.Button_five
import kotlinx.android.synthetic.main.activity_main.Button_four
import kotlinx.android.synthetic.main.activity_main.Button_multiply
import kotlinx.android.synthetic.main.activity_main.Button_nine
import kotlinx.android.synthetic.main.activity_main.Button_one
import kotlinx.android.synthetic.main.activity_main.Button_seven
import kotlinx.android.synthetic.main.activity_main.Button_six
import kotlinx.android.synthetic.main.activity_main.Button_sub
import kotlinx.android.synthetic.main.activity_main.Button_three
import kotlinx.android.synthetic.main.activity_main.Button_two
import kotlinx.android.synthetic.main.activity_main.Button_zero
import kotlinx.android.synthetic.main.activity_main.input
import kotlinx.android.synthetic.main.activity_main.output
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button_clear.setOnClickListener{
            input.text=""
            output.text=""
        }
        Button_bracket_left.setOnClickListener{
            input.text=addtoinput("(")
        }
        Button_bracket_right.setOnClickListener{
            input.text=addtoinput(")")
        }
        Button_divide.setOnClickListener{
            input.text=addtoinput("÷")
        }
        Button_seven.setOnClickListener{
            input.text=addtoinput("7")
        }
        Button_eight.setOnClickListener{
            input.text=addtoinput("8")
        }
        Button_nine.setOnClickListener{
            input.text=addtoinput("9")
        }
        Button_multiply.setOnClickListener{
            input.text=addtoinput("×")
        }
        Button_four.setOnClickListener{
            input.text=addtoinput("4")
        }
        Button_five.setOnClickListener{
            input.text=addtoinput("5")
        }
        Button_six.setOnClickListener{
            input.text=addtoinput("6")
        }
        Button_sub.setOnClickListener{
            input.text=addtoinput("-")
        }
        Button_one.setOnClickListener{
            input.text=addtoinput("1")
        }
        Button_two.setOnClickListener{
            input.text=addtoinput("2")
        }
        Button_three.setOnClickListener{
            input.text=addtoinput("3")
        }
        Button_add.setOnClickListener{
            input.text=addtoinput("+")
        }
        Button_zero.setOnClickListener{
            input.text=addtoinput("0")
        }
        Button_dot.setOnClickListener{
            input.text=addtoinput(".")
        }
        Button_equal.setOnClickListener(){
            showResult()
        }
    }
    private fun addtoinput(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
//            val expression = getInputExpression()
            val result = Expression(getInputExpression()).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.text))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

}