package com.amk.bmi

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar


var weight_int = 0F
var height_int = 0F
var bmi = 0F
var bmistring = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight_ed = findViewById<EditText>(R.id.weight_ed)
        val height_ed = findViewById<EditText>(R.id.height_ed)
        val age_ed = findViewById<EditText>(R.id.age_ed)
        val bmi_txt = findViewById<TextView>(R.id.bmi_txt)
        val calculate_btn = findViewById<Button>(R.id.calculate_btn)
        val female_img = findViewById<ImageView>(R.id.female_img)
        val male_img = findViewById<ImageView>(R.id.male_img)
        val bmi_status = findViewById<TextView>(R.id.bmi_status)

        calculate_btn.setOnClickListener {
            if (weight_ed.text.isNotEmpty() && height_ed.text.isNotEmpty()) {
                bmi_txt.text = ""
                height_int = height_ed.text.toString().toFloat()
                weight_int = weight_ed.text.toString().toFloat()
                height_int *= height_int
                bmi = weight_int / (height_int / 10000)
                bmi_txt.text = bmi.toString()
                bmi_statusCheck()
                bmi_status.text = bmistring.toString()
            } else {
                val snack = Snackbar.make(it, "Enter your height and weight", Snackbar.LENGTH_LONG)
                snack.setAction("Clear All", View.OnClickListener {
                    weight_ed.text.clear()
                    height_ed.text.clear()
                    age_ed.text.clear()
                })
                snack.show()
            }
        }
        female_img.setOnClickListener {
            female_img.setImageResource(R.drawable.ic_female_pink)
            male_img.setImageResource(R.drawable.ic_male_gray)
        }
        male_img.setOnClickListener {
            male_img.setImageResource(R.drawable.ic_male_blue)
            female_img.setImageResource(R.drawable.ic_female_gray)
        }

    }

    private fun bmi_statusCheck() {
        if (bmi < 18.5) {
            bmistring = "Underweight"
        } else if (bmi < 24.9 && bmi > 18.5) {
            bmistring = "Healthy"
        } else if (bmi < 29.9 && bmi > 25) {
            bmistring = "Overweight"
        } else if (bmi < 39.9 && bmi > 30) {
            bmistring = "Obesity"
            bmi
        }
    }
}