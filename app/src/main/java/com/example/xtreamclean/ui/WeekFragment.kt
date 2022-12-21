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


class WeekFragment : Fragment() {

    private lateinit var binding : FragmentWeekBinding
    private lateinit var mList : List<Int>

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
        mList = listOf(1, 2, 3)
        weekTaskAdapter = TaskRecyAdapter(mList)

        binding.weekTaskRecy.apply {
            adapter = weekTaskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}