package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.FragmentTomorrowBinding
import com.example.xtreamclean.databinding.FragmentWeekBinding
import com.example.xtreamclean.model.TaskData


class WeekFragment : Fragment() {

    private lateinit var binding : FragmentWeekBinding
    private lateinit var mList : MutableList<TaskData>


    private lateinit var weekTaskAdapter : TaskRecyAdapter
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
        binding = FragmentWeekBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mList = mutableListOf()
        mList.add(TaskData("1","1","OVERDUE","Seahaven Unit 1 Shoal Bay Road 81","1/81 Shoal Bay Road","Guest Stay General Departure Clean","High","22-12-2022 10:48:00"))
        mList.add(TaskData("1","1","OVERDUE","Bluehaven Unit 44 Ring 31","1/11 Ring Road","Guest Stay General Departure Clean","High","22-12-2022 21:48:00"))
        mList.add(TaskData("1","1","PENDING","FinLand Place 33","33  Place","Owner Stay General Departure Clean","High","25-12-2022 03:15:00"))
        mList.add(TaskData("1","1","PENDING","Wyalong Place 6","6 Wyalong Place","Owner Stay General Departure Clean","High","23-12-2022 03:15:00"))
        mList.add(TaskData("1","1","PENDING","Cook Street, 4","4 Cook Street","Guest Stay General Departure Clean","High","23-12-2022 06:30:00"))

        weekTaskAdapter = TaskRecyAdapter(mList)

        binding.weekTaskRecy.apply {
            adapter = weekTaskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}