package com.example.paginationlibrarykotlin.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paginationlibrarykotlin.model.Result


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/02/2021
 */
class MyFactoryDataSource : DataSource.Factory<Int, Result>() {
    private var mutableLiveData: MutableLiveData<MydataSource>? = null
    init {
        mutableLiveData = MutableLiveData()
    }
    override fun create(): DataSource<Int, Result> {
        val myDataSource =MydataSource()
        mutableLiveData?.postValue(myDataSource)
        return myDataSource
    }
}