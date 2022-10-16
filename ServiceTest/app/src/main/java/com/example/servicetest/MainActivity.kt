package com.example.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var downloadBinder : MyService.DownloadBinder

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(p0:ComponentName?, p1: IBinder?) {
            downloadBinder = p1 as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProcess()
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent) //启动Service
        }
        stopServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent) //结束Service
        }

        bindServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

        unbindServiceBtn.setOnClickListener {
            unbindService(connection  )
        }
    }
}