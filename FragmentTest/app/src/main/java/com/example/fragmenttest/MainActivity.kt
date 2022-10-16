package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.left_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        button.setOnClickListener {
//            replaceFragment(AnotherRightFragment())
//        }
//        replaceFragment(RightFragment())
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager //创建待添加的Fragment实例，使用getSupportFragmentManager()获取FragmentManager
//        val transaction = fragmentManager.beginTransaction() //开启一个事务(transaction)
//        transaction.replace(R.id.rightLayout, fragment) //向容器内添加或替换Fragment，一般使用replace()实现
//        transaction.addToBackStack(null)
//        transaction.commit() //提交事务，调用commit()完成
//    }
}