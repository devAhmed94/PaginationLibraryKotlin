package com.example.paginationlibrarykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationlibrarykotlin.adapter.MyAdapter
import com.example.paginationlibrarykotlin.model.MainResponse
import com.example.paginationlibrarykotlin.model.Result
import com.example.paginationlibrarykotlin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val myAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initViewModel()
    }

    private fun initRecycler() {
        rvMain.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    applicationContext,
                    LinearLayoutManager.VERTICAL
                )
            )
            adapter = myAdapter
        }
    }
    private fun initViewModel(){
        ViewModelProvider(this).get(MainViewModel::class.java)
            .getLiveResultList()?.observe(this, Observer {
                if (it != null){
                    myAdapter.submitList(it)
                }else{
                    Toast.makeText(this,"failed ",Toast.LENGTH_SHORT).show()
                }
            })
    }
}