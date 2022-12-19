package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.FragmentTaskDetailBinding
import com.example.xtreamclean.databinding.TaskItemLayoutBinding


class TaskDetailFragment : Fragment() {

    private lateinit var binding : FragmentTaskDetailBinding

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
        binding = FragmentTaskDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       buttonsinit()
    }

    private fun buttonsinit(){
        binding.costTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_taskDetailFragment_to_costFragment)
        }
        binding.issueTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_taskDetailFragment_to_issuesFragment)
        }
        binding.reservationTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_taskDetailFragment_to_reservationNotesFragment)
        }
        binding.summaryTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_taskDetailFragment_to_summaryFragment)
        }
        binding.taskDetailTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_taskDetailFragment_to_detailFragment)
        }
    }

}