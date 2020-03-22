package com.example.githubsearcher.view.Screen2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.githubsearcher.R
import com.example.githubsearcher.model.NameResponse
import java.time.LocalDate
import java.time.format.DateTimeFormatter


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
        if (data.email!= null){
        email.text = data.email}
        else{email.text = "no email set"}
        if(data.location != null){
            location.text = data.location
        }
        else{location.text = "no location set"}
        var beforeDate = data.created_at.substring(0, 10)
        var parseDate = LocalDate.parse(
            beforeDate,
            DateTimeFormatter.ISO_DATE
        )
        var formatDate = parseDate.format(DateTimeFormatter.ofPattern("MMMM dd, YYYY"))
        joinDate.text = formatDate.toString()
        followers.text = "Followers: " + data.followers
        following.text = "Following: " + data.following
        bio.text = data.bio
    }
}