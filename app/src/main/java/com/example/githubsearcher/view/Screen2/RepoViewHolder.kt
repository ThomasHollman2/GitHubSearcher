package com.example.githubsearcher.view.Screen2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearcher.R
import com.example.githubsearcher.model.ReposResponse

class RepoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    val repoName : TextView = itemView.findViewById(R.id.screen2_repo_name)
    val forks : TextView = itemView.findViewById(R.id.screen2_forks)
    val stars : TextView = itemView.findViewById(R.id.screen2_stars)

    fun bindData(data : ReposResponse){
        repoName.text = data.name
        forks.text = "Forks : " + data.forks.toString()
        stars.text = "Stars: " + data.stargazers_count.toString()
    }
}