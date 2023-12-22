package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.second_task.Product
import com.example.second_task.R

class myadapter(var data:List<Product>) : RecyclerView.Adapter<myadapter.myviewholder>() {

    class myviewholder(var a:View ): RecyclerView.ViewHolder(a)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        var h = myviewholder(LayoutInflater.from(parent.context).inflate(R.layout.items ,parent,false))
        return h
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        var tv1 = holder.itemView.findViewById<TextView>(R.id.id)
        var tv2 = holder.itemView.findViewById<TextView>(R.id.tv_1)
        var tv3 = holder.itemView.findViewById<TextView>(R.id.tv_2)
        var tv4 = holder.itemView.findViewById<TextView>(R.id.tv_3)
        var tv5 = holder.itemView.findViewById<TextView>(R.id.tv_4)
        var tv6 = holder.itemView.findViewById<TextView>(R.id.tv_5)
        var img_api = holder.itemView.findViewById<ImageView>(R.id.img_1)


        Glide.with(img_api).load(data.get(position).image).into(img_api)
        tv1.text = data[position].id.toString()
        tv2.text = data[position].category.toString()
        tv3.text = data[position].description.toString()
        tv4.text = data[position].price.toString()
        tv6.text = data[position].title.toString()
        tv5.text = data[position].rating.rate.toString()

    }
    override fun getItemCount(): Int {
        return data.size
    }


}