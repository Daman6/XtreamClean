package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.FragmentAllBinding
import com.example.xtreamclean.databinding.FragmentWeekBinding


class AllFragment : Fragment() {

    private lateinit var binding : FragmentAllBinding
    private lateinit var mList : List<Int>
    private lateinit var allTaskAdapter : TaskRecyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mList = listOf(1, 2, 3)
        allTaskAdapter = TaskRecyAdapter(mList)

        binding.allTaskRecy.apply {
            adapter = allTaskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}