package com.example.fragmentbestpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentActivity : AppCompatActivity() {

    companion object { //使用伴生类以实现在类中定义一部分静态方法
        fun actionStart(context: Context, title: String, content: String) { //定义actionStart方法优化了Activity的启动
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        val title = intent.getStringExtra("news_title") //获取传入的新闻标题
        val content = intent.getStringExtra("news_content") //获取传入的新闻内容
        if(title != null && content != null) { //加判空处理
            val fragment = newsContentFrag as NewsContentFragment //这里的newsContentFrag是activity_news_content.xml中的布局id
            fragment.refresh(title, content) //刷新NewsContentFragment界面
        }
    }

}