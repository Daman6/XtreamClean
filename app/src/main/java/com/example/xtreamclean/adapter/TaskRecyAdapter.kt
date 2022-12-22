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
import com.example.xtreamclean.databinding.TaskItemLayoutBinding
import com.example.xtreamclean.model.TaskData
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TaskRecyAdapter (private val list : MutableList<TaskData>): RecyclerView.Adapter<TaskRecyAdapter.TaskRecyAdapterViewHolder>(){

    class TaskRecyAdapterViewHolder(var binding : TaskItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.ENGLISH)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskRecyAdapterViewHolder {
        val binding : TaskItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.task_item_layout,
            parent,
            false
        )
        return TaskRecyAdapterViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TaskRecyAdapterViewHolder, position: Int) {
        val current = list[position]
        holder.itemView.apply {
            holder.binding.propertyTitleText.text= current.property_name.toString()
            holder.binding.addressSubtitleText.text= current.address.toString()
            holder.binding.dutyText.text= current.task_detail.toString()
            holder.binding.statusText.text= current.status.toString()

            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            val localDateTime= LocalDateTime.parse(current.checkOutDate,formatter)
            Log.e("local Date",localDateTime.toString())
            val formatter2  = DateTimeFormatter.ofPattern("EEE , MMM dd")
            val formattedDate = localDateTime.format(formatter2)
            Log.e("formatted Date",formattedDate.toString())
            val formatter3  = DateTimeFormatter.ofPattern("hh:mm a")
            val formattedTime = localDateTime.format(formatter3)
            Log.e("formatted time",formattedTime.toString())

            holder.binding.dueDateText.text = "Due on $formattedDate"
            holder.binding.checkoutTimeText.text = "OUT $formattedTime"







//            holder.binding.dueDateText.text= current.status.toString()

            setOnClickListener {
//                val bundle = Bundle()
//                bundle.putString("title",current.title)
//                bundle.putInt("id",current.id)
//                bundle.putInt("userId",current.userId)
//                bundle.putString("body",current.body)

                findNavController().navigate(R.id.action_homeFragment_to_taskDetailFragment)
            }
        }





    }

    override fun getItemCount(): Int {
        return list.size
    }
//    fun getDateString(time: Long) : Stringg = simpleDateFormatateFormat.format(time * 1000)

    fun getDateString(time: Int) : String = simpleDateFormat.format(time * 1000L)

}