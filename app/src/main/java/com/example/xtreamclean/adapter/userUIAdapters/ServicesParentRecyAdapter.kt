package com.example.xtreamclean.adapter.userUIAdapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.ServicesNameItemLayoutBinding

class ServicesParentRecyAdapter (private val tilteList : List<String>,private val imagesList : List<Int>, private val activity: FragmentActivity): RecyclerView.Adapter<ServicesParentRecyAdapter.servicesParentRecyAdapterViewHolder>(){

    class servicesParentRecyAdapterViewHolder(var binding : ServicesNameItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): servicesParentRecyAdapterViewHolder {
        val binding : ServicesNameItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.services_name_item_layout,
            parent,
            false
        )
        return servicesParentRecyAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: servicesParentRecyAdapterViewHolder, position: Int) {
        val current = tilteList[position]

        holder.binding.serviceTitle.text = current.toString()
        val childRecyAdapter= ServicesChildRecyAdapter(imagesList)
        val linearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.serviceImagesRecy.apply {
            layoutManager= linearLayoutManager
            adapter = childRecyAdapter
        }
        holder.binding.linear.apply {
            setOnClickListener {
                val bundle = Bundle()
                bundle.putString("service_title",current.toString())
                findNavController().navigate(R.id.action_userHomeFragment_to_serviceDetailFragment,bundle)
            }
        }
        holder.binding.serviceImagesRecy.apply {
            setOnClickListener {
                val bundle = Bundle()
                bundle.putString("service_title",current.toString())
                findNavController().navigate(R.id.action_userHomeFragment_to_serviceDetailFragment,bundle)
            }
        }



    }

    override fun getItemCount(): Int {
        return tilteList.size
    }
}