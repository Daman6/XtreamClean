package com.example.xtreamclean.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.FragmentTodayBinding
import com.example.xtreamclean.model.TaskData
import java.text.SimpleDateFormat


class TodayFragment : Fragment() {

    private lateinit var binding: FragmentTodayBinding
    private lateinit var mAdapter: TaskRecyAdapter
    private lateinit var mList : MutableList<TaskData>

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
        mList = mutableListOf()

        mList.add(TaskData("1","1","OVERDUE","Seahaven Unit 1 Shoal Bay Road 81","1/81 Shoal Bay Road","Guest Stay General Departure Clean","High","22-12-2022 10:48:00"))
        mList.add(TaskData("1","1","OVERDUE","Bluehaven Unit 44 Ring 31","1/11 Ring Road","Guest Stay General Departure Clean","High","22-12-2022 21:48:00"))
        mAdapter = TaskRecyAdapter(mList)

        binding.taskRecy.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


}