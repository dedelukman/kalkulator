package com.abahstudio.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var op="*"
    var oldNumber=""
    var isNewOp=true
    var isPercen=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buEventNumber(view: View) {
        if (isNewOp){
            etShowNumber.setText("")
        }
        isNewOp=false
        val buSelect  = view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buSelect.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            buDot.id->{
                if (!etShowNumber.text.contains(".")){
                    if (etShowNumber.text.length==0){
                        buClickValue+="0."
                    }else{
                        buClickValue+="."
                    }
//                    isDot=true
                }
            }
            buPlusMinus.id->{
                if (!etShowNumber.text.contains("-")){
                    if (etShowNumber.text.length==0){
                        buClickValue="-0" +buClickValue
                    }else{
                        buClickValue="-" +buClickValue
                    }
                }else{
                    buClickValue=buClickValue.replace("-","",true)
                }
            }

        }
        etShowNumber.setText(buClickValue)
    }


    fun buEventOp(view: View) {

        val buSelect = view as Button
        when (buSelect.id) {
            buMul.id -> {
                op="*"
            }
            buDiv.id -> {
                op="/"
            }
            buSub.id -> {
                op="-"
            }
            buSum.id -> {
                op="+"
            }
        }
        oldNumber=etShowNumber.text.toString()
        isNewOp=true
    }

    fun buEventEqual(view: View) {
        val newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber=oldNumber.toDouble()*newNumber.toDouble()
            }
            "/"->{
                finalNumber=oldNumber.toDouble()/newNumber.toDouble()
            }
            "+"->{
                finalNumber=oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber=oldNumber.toDouble()-newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buEventPercen(view: View) {
        if (etShowNumber.text.length>0) {
            if (isPercen) {
                val number: Double = etShowNumber.text.toString().toDouble() * 100
                etShowNumber.setText(number.toString())
                isPercen = false
            } else {
                val number: Double = etShowNumber.text.toString().toDouble() / 100
                etShowNumber.setText(number.toString())
                isPercen = true
            }
            isNewOp = true
        }
    }

    fun buEventClean(view: View) {
        etShowNumber.setText("0")
        isNewOp=true
        isPercen=false

    }


}
