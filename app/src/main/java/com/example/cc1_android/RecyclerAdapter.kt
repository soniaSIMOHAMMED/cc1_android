package com.example.cc1_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val products : List<Product>, val listener : OnItemClickedListener) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(products[position].urlImg);
        //holder.itemNutriscoreImage.setImageResource(registerImg[position])
        holder.itemPetitPoisText.text = products[position].name
        holder.itemCassegrainText.text = products[position].brand
        holder.itemView.setOnClickListener { listener.onItemClicked(position) }


    }

    override fun getItemCount(): Int {
        return products.size;
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var itemImage: ImageView
    //var itemNutriscoreImage: ImageView
    var itemPetitPoisText: TextView
    var itemCassegrainText: TextView

    init {
        itemImage = itemView.findViewById(R.id.placeholder)
       // itemNutriscoreImage = itemView.findViewById(R.id.register_image)
        itemPetitPoisText = itemView.findViewById(R.id.petits_pois)
        itemCassegrainText = itemView.findViewById(R.id.cassegrain)
    }
}


interface OnItemClickedListener{

    fun onItemClicked(position: Int)
}

