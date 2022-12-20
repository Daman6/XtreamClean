package com.example.xtreamclean.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.ElementsItemLayoutBinding
import com.example.xtreamclean.databinding.TaskItemLayoutBinding

class PropertyDetailElementRecyAdapter (private val list : List<Int>): RecyclerView.Adapter<PropertyDetailElementRecyAdapter.PropertyDetailElementRecyAdapterViewHolder>(){

    class  PropertyDetailElementRecyAdapterViewHolder(var binding : ElementsItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyDetailElementRecyAdapterViewHolder {
        val binding : ElementsItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.elements_item_layout,
            parent,
            false
        )
        return PropertyDetailElementRecyAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyDetailElementRecyAdapterViewHolder, position: Int) {
        val current = list[position]
        holder.itemView.apply {
//            holder.binding.title.text= current.title.toString()
            setOnClickListener {
//                val bundle = Bundle()
//                bundle.putString("title",current.title)
//                bundle.putInt("id",current.id)
//                bundle.putInt("userId",current.userId)
//                bundle.putString("body",current.body)

                findNavController().navigate(R.id.action_productDetailFragment_to_elementDetailFragment)
            }
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}