package com.example.xtreamclean.adapter.userUIAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.ServicesImagesItemLayoutBinding

class ServicesChildRecyAdapter (private val imagesList : List<Int>): RecyclerView.Adapter<ServicesChildRecyAdapter.servicesChildRecyAdapterViewHolder>(){

    class servicesChildRecyAdapterViewHolder(var binding : ServicesImagesItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): servicesChildRecyAdapterViewHolder {
        val binding : ServicesImagesItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.services_images_item_layout,
            parent,
            false
        )
        return servicesChildRecyAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: servicesChildRecyAdapterViewHolder, position: Int) {
        val current = imagesList[position]
        holder.binding.servicesImages.setImageResource(current)


    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}