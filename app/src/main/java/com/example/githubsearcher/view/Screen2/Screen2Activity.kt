package com.example.githubsearcher.view.Screen2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearcher.R
import com.example.githubsearcher.model.NameResponse
import com.example.githubsearcher.model.ReposResponse
import com.example.githubsearcher.view.Screen1.MainActivity
import com.example.githubsearcher.viewmodel.Screen2ViewModel
import kotlinx.android.synthetic.main.screen2.*


class Screen2Activity:AppCompatActivity() {
    lateinit var viewModel2: Screen2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen2)

        val repoAdapter = RepoAdapter()
        recycler_view2.layoutManager = LinearLayoutManager(this)
        recycler_view2.adapter = repoAdapter

        val userLogin = intent.getStringExtra(MainActivity.userLogin)
        val userInfoViewHolder  = Screen2ViewHolder(findViewById(R.id.scroll_view))

        viewModel2 = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return Screen2ViewModel("https://api.github.com/") as T
                }
            }
        ).get(Screen2ViewModel::class.java)

        viewModel2.getNameData().observe(
            this,
            object : Observer<NameResponse> {
                override fun onChanged(t: NameResponse?) {
                    userInfoViewHolder.bindData(t!!)
                }
            }
        )
        viewModel2.getRepoData().observe(
            this,
            object : Observer<List<ReposResponse>>{
                override fun onChanged(t: List<ReposResponse>?) {
                    repoAdapter.data = t
                }
            }
        )
        viewModel2.initUserInfo(userLogin)

    }
}