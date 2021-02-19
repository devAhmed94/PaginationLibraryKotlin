package com.example.paginationlibrarykotlin.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.paginationlibrarykotlin.model.MainResponse
import com.example.paginationlibrarykotlin.model.Result
import com.example.paginationlibrarykotlin.network.ApiServices
import com.example.paginationlibrarykotlin.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/02/2021
 */
class MydataSource : PageKeyedDataSource<Int,Result>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        RetrofitInstance.getRetrofitInstance().create(ApiServices::class.java).getCharacters(1)
            .enqueue(object : Callback<MainResponse>{
                override fun onResponse(
                    call: Call<MainResponse>,
                    response: Response<MainResponse>
                ) {
                    if (response.isSuccessful && response !=null){
                        callback.onResult(response.body()?.results!!,null,2)
                    }
                }

                override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        RetrofitInstance.getRetrofitInstance().create(ApiServices::class.java).getCharacters(params.key)
            .enqueue(object : Callback<MainResponse> {
                override fun onResponse(
                    call: Call<MainResponse>,
                    response: Response<MainResponse>
                ) {
                    if (response.isSuccessful && response != null) {
                        callback.onResult(response.body()?.results!!, params.key + 1)
                    }
                }

                override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            })
    }
}