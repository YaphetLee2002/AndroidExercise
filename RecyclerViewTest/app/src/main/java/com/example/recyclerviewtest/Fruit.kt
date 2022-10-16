package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import kotlinx.android.synthetic.main.fruit_item.view.*

class Fruit(val name:String, val imageId: Int)

class FruitAdapter(val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //用于创建ViewHolder实例
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you click view ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you click image ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //对RecyclerView子项数据进行赋值，在每个子项数据滚动到屏幕执行
        val fruit = fruitList[position]
        holder.fruitName.text = fruit.name
        holder.fruitImage.setImageResource(fruit.imageId)
    }

    override fun getItemCount() = fruitList.size //返回数据源的长度

}