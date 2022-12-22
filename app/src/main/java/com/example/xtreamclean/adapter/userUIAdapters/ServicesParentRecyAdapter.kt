package com.example.xtreamclean.adapter.userUIAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
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
        return tilteList.size
    }
}