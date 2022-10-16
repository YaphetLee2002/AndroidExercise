package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
//                val inputText = editText.text.toString()
//                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
//                imageView.setImageResource(R.drawable.img2)
//                if(processBar.visibility == View.VISIBLE)
//                    processBar.visibility = View.GONE
//                else
//                    processBar.visibility = View.VISIBLE
//                processBar.progress += 10
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something important.")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which ->
                    }
                    setNegativeButton("CANCEL") { dialog, which ->
                    }
                    show()
                }
            }
        }
    }
}