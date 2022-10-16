package com.example.activitytest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", "Task id is $taskId")
        setContentView(R.layout.first_layout)
        button1.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java) 这个是显示的intent
//            val intent = Intent("com.example.activitytest.ACTION_START") 这个是隐式的intent
//            intent.addCategory("com.example.activitytest.MY_CATEGORY")
//            val intent = Intent(Intent.ACTION_VIEW) 这个打开一个网页
//            intent.data = Uri.parse("https://www.baidu.com")
//            val intent = Intent(Intent.ACTION_DIAL) 这里调用拨号界面（未成功）
//            intent.data = Uri.parse("tel.10086")
//            val data = "Hello SecondActivity" 这里用于向下一个activity传递数据
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", data)
//            startActivity(intent)
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivityForResult(intent, 1)
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            SecondActivity.actionStart(this, "data1", "data2")
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add_item -> Toast.makeText(this, "You click Add",
                             Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You click Remove",
                                Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if(resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "return data is $returnedData")
            }
        }
    }
}