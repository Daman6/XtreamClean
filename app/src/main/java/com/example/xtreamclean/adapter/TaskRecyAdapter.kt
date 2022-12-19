package com.example.xtreamclean.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.TaskItemLayoutBinding

class TaskRecyAdapter (private val list : List<Int>): RecyclerView.Adapter<TaskRecyAdapter.TaskRecyAdapterViewHolder>(){

    class TaskRecyAdapterViewHolder(var binding : TaskItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskRecyAdapterViewHolder {
        val binding : TaskItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.task_item_layout,
            parent,
            false
        )
        return TaskRecyAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskRecyAdapterViewHolder, position: Int) {
        val current = list[position]
        holder.itemView.apply {
//            holder.binding.title.text= current.title.toString()
//            setOnClickListener {
//                val bundle = Bundle()
//                bundle.putString("title",current.title)
//                bundle.putInt("id",current.id)
//                bundle.putInt("userId",current.userId)
//                bundle.putString("body",current.body)
//
//                findNavController().navigate(R.id.action_homeFragment_to_contentFragment,bundle)
//            }
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}