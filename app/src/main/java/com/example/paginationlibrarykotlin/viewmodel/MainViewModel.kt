package com.example.paginationlibrarykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paginationlibrarykotlin.datasource.MyFactoryDataSource
import com.example.paginationlibrarykotlin.model.Result
import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/02/2021
 */
class MainViewModel : ViewModel() {
    private var resultList: LiveData<PagedList<Result>>? = null

    init {
        initPaginarion()
    }

    private fun initPaginarion() {
        val factory = MyFactoryDataSource()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(34)
            .build()
        val excuter = Executors.newFixedThreadPool(5)
        resultList = LivePagedListBuilder<Int, Result>(factory, config)
            .setFetchExecutor(excuter)
            .build()

    }

    fun getLiveResultList() = resultList
}