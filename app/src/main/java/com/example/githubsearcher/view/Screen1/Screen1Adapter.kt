package com.example.githubsearcher.view.Screen1

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearcher.R
import com.example.githubsearcher.model.searchItems

class Screen1Adapter(val clickListener : (searchItems) -> Unit):RecyclerView.Adapter<Screen1ViewHolder>() {
    private val TAG = Screen1Adapter::class.java.simpleName
    var dataSet: List<searchItems>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Screen1ViewHolder =
        Screen1ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.screen1_rv,
                    parent,
                    false
                )
        )


    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount" + dataSet?.size)
        return dataSet?.size ?: 0
    }

    override fun onBindViewHolder(holder: Screen1ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder" + dataSet?.get(position))
        dataSet?.get(position)?.let {
            holder.onBind(it, clickListener)}
    }
}