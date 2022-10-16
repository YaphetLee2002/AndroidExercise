package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    //重写了onReceive方法，加入了一个小Toast
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show()
        abortBroadcast()  //添加abortBroadcast以截断后续的有序广播
    }
}