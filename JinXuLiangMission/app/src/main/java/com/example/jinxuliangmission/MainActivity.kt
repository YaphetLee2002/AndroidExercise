package com.example.jinxuliangmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button ->{
                val textView: TextView = findViewById(R.id.textView)
                val editText: EditText = findViewById(R.id.editText)
                val age = 2022 - editText.text.toString().toInt()
                if(age in (0..120)) {
                    textView.setText("Your age is ${age}")
                } else {
                    Toast.makeText(this, "You has input the wrong year!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}