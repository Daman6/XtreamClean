package com.example.xtreamclean.ui.propertyDetailTabFraments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.PropertyDetailElementRecyAdapter
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.ElementsItemLayoutBinding
import com.example.xtreamclean.databinding.FragmentElementBinding


class ElementFragment : Fragment() {


    private lateinit var binding: FragmentElementBinding
    private lateinit var mAdapter: PropertyDetailElementRecyAdapter
    private lateinit var mList: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentElementBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mList = listOf(1, 2, 3)
        mAdapter = PropertyDetailElementRecyAdapter(mList)

        binding.elementRecy.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }
}