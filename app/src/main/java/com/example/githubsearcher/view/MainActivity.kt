package com.example.githubsearcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearcher.R
import com.example.githubsearcher.model.SearchResponse
import com.example.githubsearcher.viewmodel.Screen1ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val screen1_adapter = Screen1Adapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter= screen1_adapter

        val viewModel = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return Screen1ViewModel("https://api.github.com/")
                            as T
                }
            }
        ).get(Screen1ViewModel::class.java)

      viewModel.getSearchData().observe(
          this, object : Observer<SearchResponse>{
              override fun onChanged(t: SearchResponse?) {
                  screen1_adapter.dataSet = t?.items
              }
          }
      )
        initSearchBar(viewModel)

    }


    private fun initSearchBar(viewModel: Screen1ViewModel) {
        et_search_users.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {

                }
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    viewModel.searchBar(et_search_users.text.toString())
                }

            }
        )
    }

}
