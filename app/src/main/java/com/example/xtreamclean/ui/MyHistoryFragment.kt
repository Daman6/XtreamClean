package com.example.xtreamclean.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.MyHistory_TaskRecyAdapter
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.databinding.FragmentMyHistoryBinding


class MyHistoryFragment : Fragment() {

    private lateinit var binding: FragmentMyHistoryBinding
    private lateinit var mAdapter: MyHistory_TaskRecyAdapter
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
        binding = FragmentMyHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mList = listOf(1,2,3)
        mAdapter = MyHistory_TaskRecyAdapter(mList,requireActivity())

        binding.historyRecy.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        setUpNavMenu()
    }


    private fun setUpNavMenu(){
        binding.hamMenuBtn.setOnClickListener {
            if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) binding.drawerLayout.openDrawer(
                GravityCompat.START
            );
            else binding.drawerLayout.closeDrawer(GravityCompat.END);

        }




        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mytaskBtn ->{
                    findNavController().navigate(R.id.homeFragment)
                }
                R.id.offerBtn -> {
                    findNavController().navigate(R.id.action_homeFragment_to_offerFragment)
                }
                R.id.myHistoryBtn -> {
                    findNavController().navigate(R.id.action_homeFragment_to_myHistoryFragment)
                }

            }
            true
        }
    }
}