package com.example.myredandblue

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnChangeColor= findViewById<Button>(R.id.btnChangeColor)
        var isBlue = false
        btnChangeColor.setOnClickListener {
            val btn: Button = it as Button
            if (isBlue) {
                btn.text = "蓝"
                btn.setTextColor(Color.BLUE)
            } else {
                btn.text = "红"
                btn.setTextColor(Color.RED)
            }
            isBlue = !isBlue
        }
    }
}