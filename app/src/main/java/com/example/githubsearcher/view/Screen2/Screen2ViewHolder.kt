package com.example.githubsearcher.view.Screen2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.githubsearcher.R
import com.example.githubsearcher.model.NameResponse


class Screen2ViewHolder(val itemView: View) {
    val userImage : ImageView = itemView.findViewById(R.id.screen2_iv)
    val login : TextView = itemView.findViewById(R.id.screen2_username)
    val email : TextView = itemView.findViewById(R.id.screen2_email)
    val location : TextView = itemView.findViewById(R.id.screen2_location)
    val joinDate : TextView = itemView.findViewById(R.id.screen2_joindate)
    val followers : TextView = itemView.findViewById(R.id.screen2_followers)
    val following : TextView = itemView.findViewById(R.id.screen2_following)
    val bio : TextView = itemView.findViewById(R.id.screen2_bio)

    fun bindData(data : NameResponse){
        Glide.with(itemView).load(data.avatar_url).into(userImage)
        login.text = data.login
        email.text = data.email
        location.text = data.location
        joinDate.text = data.created_at
        followers.text = "Followers: " + data.followers
        following.text = "Following: " + data.following
        bio.text = data.bio
    }
}