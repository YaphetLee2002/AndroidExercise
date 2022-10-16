package com.example.menutest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import java.lang.Exception
import java.lang.reflect.Method

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        setIconEnable(menu!!, true)
        menuInflater.inflate(R.menu.mymenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId) {
            R.id.
        }
    }
}

private fun setIconEnable(menu: Menu, enable: Boolean) {
    try {
        val clazz =
            Class.forName("androidx.appcompat.view.menu.MenuBuilder")
        val m: Method = clazz.getDeclaredMethod(
            "setOptionalIconVisible",
            Boolean::class.javaPrimitiveType
        )
        m.isAccessible = true
        m.invoke(menu, enable)
    } catch (e: Exception) {
        e.printStackTrace()
    }

}