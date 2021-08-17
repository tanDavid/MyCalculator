package com.myapplicationdev.android.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var checkNewOper = true
    var dot = false
    var plusMinus = "+"
    fun btnNumEvent(view: View) {
        if (checkNewOper) {
            etShowNumber.setText("")
        }
        checkNewOper = false
        val btnSelect = view as Button
        var buClickValue: String = etShowNumber.text.toString()
        when (btnSelect.id) {
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                if (dot == false) {
                    buClickValue += "."
                }
                dot = true
            }
            buPlusMinus.id -> {
                if (plusMinus == "+") {
                    buClickValue = "-" + buClickValue
                    plusMinus = "-"

                }else if(plusMinus == "-") {
                    buClickValue = buClickValue.replace("-", "")
                    plusMinus = "+"
                }
//                plusMinus = "+"
            } 
        }
        etShowNumber.setText(buClickValue)
    }

    var op = "X"
    var oldNumber = ""

    fun btnOperEvent(view: View) {
        val buSelect = view as Button
        when (buSelect.id) {
            btnMult.id -> {
                op = "*"
            }
            btnSlash.id -> {
                op = "/"

            }
            btnMinus.id -> {
                op = "-"
            }
            btnAdd.id -> {
                op = "+"
            }

        }
        oldNumber = etShowNumber.text.toString()
        checkNewOper = true
        dot = false
    }

    fun btnEqualsEvent(view: View) {
        val newNumber = etShowNumber.text.toString()
        var finalNumber: Double? = null
        when (op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        checkNewOper = true
    }

    fun btnClear(view: View) {
        etShowNumber.setText("")
        checkNewOper = true
        dot = false
    }

    fun btnPercentEvent(view: View) {
        val number = (etShowNumber.text.toString().toDouble()) / 100
        etShowNumber.setText(number.toString())
        checkNewOper = true
    }

}