package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceive : TimeChangeReceive

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //定义了一个button，设置点击事件（发送广播）
        val button : Button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent("com.example.broadcasttest.MY_BROADCAST") //构建一个intent传入要发送的广播的值
            intent.setPackage(packageName) //传入当前程序的包名，使用setPackage确定这个intent发给哪个程序，使之成为显式广播
            sendOrderedBroadcast(intent, null) //发送广播
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceive = TimeChangeReceive()
        registerReceiver(timeChangeReceive, intentFilter)
    }

    override fun onDestroy() { //重写onDestroy方法
        super.onDestroy()
        unregisterReceiver(timeChangeReceive)
    }

    inner class TimeChangeReceive : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }
    }

}