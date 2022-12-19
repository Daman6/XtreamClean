package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.FragmentTodayBinding


class TodayFragment : Fragment() {

    private lateinit var binding: FragmentTodayBinding
    private lateinit var mAdapter: TaskRecyAdapter
    private lateinit var mList : List<Int>

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
        binding =  FragmentTodayBinding.inflate(layoutInflater)
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mList = listOf(1,2,3,4,5,6,7)
        mAdapter = TaskRecyAdapter(mList)

        binding.taskRecy.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


}