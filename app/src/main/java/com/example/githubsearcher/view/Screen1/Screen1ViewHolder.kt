package com.example.githubsearcher.view.Screen1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubsearcher.R
import com.example.githubsearcher.model.searchItems


class Screen1ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val userLogin: TextView = itemView.findViewById(R.id.screen1_username_tv)
    val userPhoto: ImageView = itemView.findViewById(R.id.screen1_iv)

    fun onBind(item: searchItems,clickListener : (searchItems) -> Unit){
        userLogin.text= item.login
        Glide.with(itemView).load(item.avatar_url).into(userPhoto)
        itemView.setOnClickListener{clickListener(item)}

    }

}