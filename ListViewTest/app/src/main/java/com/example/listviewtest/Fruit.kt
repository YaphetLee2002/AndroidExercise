package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fruit_item.view.*

class Fruit(val name:String, val imageId: Int)

class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
        ArrayAdapter<Fruit>(activity, resourceId, data) {
    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) { //这里用来缓存已经加载过的就不要重新加载了，提高速度
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder //已经加载过的，取出，转化为ViewHolder内部类
        }
        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
}
