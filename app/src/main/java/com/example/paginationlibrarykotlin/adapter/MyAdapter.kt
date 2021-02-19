package com.example.paginationlibrarykotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginationlibrarykotlin.R
import com.example.paginationlibrarykotlin.model.Result
import kotlinx.android.synthetic.main.item_recycler.view.*


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/02/2021
 */
class MyAdapter : PagedListAdapter<Result, MyAdapter.MyViewHolder>(MyDiff()) {
    class MyDiff : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.name == newItem.name && oldItem.species == newItem.species
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data:Result) {
            with(itemView){
                tvName.text=data.name
                tvSpecies.text =data.species
                Glide.with(ivItem).load(data.image).centerCrop().into(ivItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }
}