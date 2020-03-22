package com.example.githubsearcher.view.Screen2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearcher.R
import com.example.githubsearcher.model.ReposResponse

class RepoAdapter :RecyclerView.Adapter<RepoViewHolder>() {
    var data : List<ReposResponse>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate( R.layout.screen2_rv, parent, false )
        )
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        data?.get(position)?.let { holder.bindData(it) }
    }
}