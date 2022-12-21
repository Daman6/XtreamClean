package com.example.xtreamclean.adapter.listadapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.DecorContentParent
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.DepartmentItemListLayoutBinding
import com.example.xtreamclean.databinding.TaskItemLayoutBinding

class DepartmentItemRecyAdapter(private val title: Array<String>, private val imgid: Array<Int>)
    : RecyclerView.Adapter<DepartmentItemRecyAdapter.itemAdapterViewHolder>(){

    class itemAdapterViewHolder(var binding : DepartmentItemListLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemAdapterViewHolder {
        val binding : DepartmentItemListLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.department_item_list_layout,
            parent,
            false
        )
        return itemAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemAdapterViewHolder, position: Int) {
        val currentTitle = title[position]
        val currentImg = imgid[position]
        holder.itemView.apply {
            holder.binding.title.text= currentTitle.toString()
            holder.binding.imageIcon.setImageResource(currentImg)

        }

    }

    override fun getItemCount(): Int {
        return title.size
    }
}