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


class TomorrowFragment : Fragment() {

    private lateinit var binding : FragmentTomorrowBinding
    private lateinit var mList : List<Int>

    private lateinit var tomorrowTaskAdapter : TaskRecyAdapter
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
        binding = FragmentTomorrowBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mList = listOf(1, 2, 3)
        tomorrowTaskAdapter = TaskRecyAdapter(mList)

        binding.tomorrowTaskRecy.apply {
            adapter = tomorrowTaskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }



    }


}