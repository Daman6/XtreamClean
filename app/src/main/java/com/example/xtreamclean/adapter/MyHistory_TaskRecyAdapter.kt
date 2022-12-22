package com.example.xtreamclean.adapter

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.MyhistoryTaskDateItemLayoutBinding
import com.example.xtreamclean.databinding.MyhistoryTaskItemLayoutBinding
import com.example.xtreamclean.databinding.TaskItemLayoutBinding
import com.example.xtreamclean.model.TaskData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyHistory_TaskRecyAdapter (private val list : MutableList<TaskData>,private val activity: FragmentActivity): RecyclerView.Adapter<MyHistory_TaskRecyAdapter.TaskRecyAdapterViewHolder>(){

    class TaskRecyAdapterViewHolder(var binding : MyhistoryTaskDateItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskRecyAdapterViewHolder {
        val binding : MyhistoryTaskDateItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.myhistory_task_date_item_layout,
            parent,
            false
        )
        return TaskRecyAdapterViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TaskRecyAdapterViewHolder, position: Int) {
        val current = list[position]

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val localDateTime= LocalDateTime.parse(current.checkOutDate,formatter)
        Log.e("local Date",localDateTime.toString())
        val formatter2  = DateTimeFormatter.ofPattern("EEE , MMM dd")
        val formattedDate = localDateTime.format(formatter2)
        Log.e("formatted Date",formattedDate.toString())
        val formatter3  = DateTimeFormatter.ofPattern("hh:mm a")
        val formattedTime = localDateTime.format(formatter3)
        Log.e("formatted time",formattedTime.toString())

        holder.binding.taskDate.text = formattedDate.toString()
        val childRecyAdapter= MyHistory_TaskChildRecyAdapter(list)
        val linearLayoutManager = LinearLayoutManager(activity)
        holder.binding.childRecy.apply {
            layoutManager= linearLayoutManager
            adapter = childRecyAdapter
        }
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