package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var input1 : Double = 0.0
    var input2: Double = 0.0
    var add : Boolean = false
    var sub : Boolean = false
    var multiplication : Boolean = false
    var division : Boolean = false
    var dot : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvExpression : TextView = findViewById(R.id.tvExpression)
        val tvResult : TextView = findViewById(R.id.tvResult)
        val btZero : Button = findViewById(R.id.btzero)
        val btOne : Button = findViewById(R.id.btone)
        val btTwo : Button = findViewById(R.id.bttwo)
        val btThree : Button = findViewById(R.id.btthree)
        val btFour : Button = findViewById(R.id.btfour)
        val btFive : Button = findViewById(R.id.btfive)
        val btSix : Button = findViewById(R.id.btsix)
        val btSeven : Button = findViewById(R.id.btseven)
        val bteight : Button = findViewById(R.id.bteight)
        val btNine : Button = findViewById(R.id.btnine)
        val btMultipication: Button = findViewById(R.id.btmultiplication)
        val btDivision : Button = findViewById(R.id.btdivision)
        val btSub : Button = findViewById(R.id.btsub)
        val btAdd : Button = findViewById(R.id.btadd)
        val btDot : Button = findViewById(R.id.btdot)
        val btEqual : Button = findViewById(R.id.btequal)
        val btClear : Button = findViewById(R.id.btclear)

        btZero.setOnClickListener {
            tvExpression.setText("${tvExpression.text}0")
        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}1")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}2")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}3")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}4")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}5")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}6")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}7")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}8")

        }
        btOne.setOnClickListener {
            tvExpression.setText("${tvExpression.text}9")

        }

        btAdd.setOnClickListener {
            if (tvExpression.getText().length != 0) {
                input1 = "${tvExpression.text}".toDouble()
                add = true
                tvExpression.setText(null)
            }
        }
        btAdd.setOnClickListener {
            if (tvExpression.getText().length != 0) {
                input1 = "${tvExpression.text}".toDouble()
                sub = true
                tvExpression.setText(null)
            }
        }
        btAdd.setOnClickListener {
            if (tvExpression.getText().length != 0) {
                input1 = "${tvExpression.text}".toDouble()
                multiplication = true
                tvExpression.setText(null)
            }
        }
        btAdd.setOnClickListener {
            if (tvExpression.getText().length != 0) {
                input1 = "${tvExpression.text}".toDouble()
                division = true
                tvExpression.setText(null)
            }
        }

        btEqual.setOnClickListener {
            input2 = "${tvExpression.text}".toDouble()
            if(add)
            {
                tvExpression.setText("${input1} + ${input2}")
                var raddition: Double = input1 + input2
                tvResult.setText("${raddition}")
                add = false
            }
            if(sub)
            {
                tvExpression.setText("${input1} - ${input2}")
                var rsub: Double = input1 - input2
                tvResult.setText("${rsub}")
                sub = false
            }
            if(multiplication)
            {
                tvExpression.setText("${input1} * ${input2}")
                var rmul: Double = input1 * input2
                tvResult.setText("${rmul}")
                multiplication = false
            }
            if(division)
            {
                tvExpression.setText("${input1} / ${input2}")
                var rdivision: Double = input1 / input2
                tvResult.setText("${rdivision}")
                division = false
            }


        }
     btClear.setOnClickListener{
         input1 = 0.0
         input2 = 0.0
         tvExpression.setText("")
         tvResult.setText("")
     }
     btDot.setOnClickListener {
         if(!dot)
         {
             tvExpression.setText("${tvExpression.text}.")
         }
         dot = true
     }


    }
}
