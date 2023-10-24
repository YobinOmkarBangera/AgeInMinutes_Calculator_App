package com.example.ageinminutes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDateOfBirth: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            calculateAgeInMinutes(it)
        }
    }

    private fun calculateAgeInMinutes(view: View) {
        val dobString = editTextDateOfBirth.text.toString()

        if (dobString.isNotEmpty()) {
            val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
            val dob = dateFormat.parse(dobString)
            val currentTime = Date()
            val diff = currentTime.time - dob.time
            val ageInMinutes = diff / (60 * 1000)
            textViewResult.text = "Your age in minutes is: $ageInMinutes"
        } else {
            textViewResult.text = "Please enter your date of birth."
        }
    }
}

