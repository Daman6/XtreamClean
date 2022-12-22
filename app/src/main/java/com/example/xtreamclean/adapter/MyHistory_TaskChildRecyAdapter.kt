package com.example.xtreamclean.adapter

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.MyhistoryTaskDateItemLayoutBinding
import com.example.xtreamclean.databinding.MyhistoryTaskItemLayoutBinding
import com.example.xtreamclean.databinding.TaskItemLayoutBinding
import com.example.xtreamclean.model.TaskData
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MyHistory_TaskChildRecyAdapter (private val list : MutableList<TaskData>): RecyclerView.Adapter<MyHistory_TaskChildRecyAdapter.TaskRecyAdapterViewHolder>(){

    class TaskRecyAdapterViewHolder(var binding : MyhistoryTaskItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskRecyAdapterViewHolder {
        val binding : MyhistoryTaskItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.myhistory_task_item_layout,
            parent,
            false
        )
        return TaskRecyAdapterViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TaskRecyAdapterViewHolder, position: Int) {
        val current = list[position]

        holder.binding.apply {
            propertyTitleText.text = current.property_name.toString()
            addressSubtitleText.text = current.address.toString()
            dutyText.text = current.task_detail.toString()
            statusText.text = current.status.toString()

            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            val localDateTime= LocalDateTime.parse(current.checkOutDate,formatter)
            Log.e("local Date",localDateTime.toString())
            val formatter2  = DateTimeFormatter.ofPattern("EEE , MMM dd")
            val formattedDate = localDateTime.format(formatter2)
            Log.e("formatted Date",formattedDate.toString())
            val formatter3  = DateTimeFormatter.ofPattern("hh:mm a")
            val formattedTime = localDateTime.format(formatter3)
            Log.e("formatted time",formattedTime.toString())


            dueText.text = "Due on $formattedDate"
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}