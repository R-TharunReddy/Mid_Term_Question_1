package com.example.midtermq1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)

        var flag: String = "sum"

        val spinnerVal: Spinner = findViewById(R.id.spinnerV)
        val options = arrayOf("Sum", "Subtraction", "Multiplication", "Division")
        spinnerVal.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        button.setOnClickListener {
            val x = edtxt1.text.toString().toIntOrNull()
            val y = edtxt2.text.toString().toIntOrNull()

            if (x != null && y != null) {
                val result = when (flag) {
                    "Sum" -> sum(x, y)
                    "Subtraction" -> subtract(x, y)
                    "Multiplication" -> multiply(x, y)
                    "Division" -> if (y != 0) divide(x, y) else "Cannot divide by zero"
                    else -> "Invalid operation"
                }
                resultTV.text = result.toString()
            } else {
                resultTV.text = "Invalid input"
            }
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
    fun sum(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
    fun multiply(a: Int, b: Int) = a * b
    fun divide(a: Int, b: Int) = a / b
}
