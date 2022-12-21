package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.listadapter.DepartmentItemRecyAdapter
import com.example.xtreamclean.databinding.FragmentCostFilterBinding


class CostFilterFragment : Fragment() {

    private lateinit var binding : FragmentCostFilterBinding
    private lateinit var departmentAdapter : DepartmentItemRecyAdapter
    private lateinit var priorityAdapter : DepartmentItemRecyAdapter
    private lateinit var reservationAdapter : DepartmentItemRecyAdapter

    val title = arrayOf<String>("Clean","Inspection","Maintenace")
    val priorityTitle = arrayOf<String>("Watch","Low","Medium","High")
    val reservationTitle = arrayOf<String>("Checkout","Check-in","Back to Back","Hold,Occupied")
    val imageId = arrayOf<Int>(
        R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24
    )
    val priorityImageId = arrayOf<Int>(
        R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24
    )
    val reservationImageId = arrayOf<Int>(
        R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24
    )

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
        binding = FragmentCostFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun setUpRecyclerView() {

        departmentAdapter = DepartmentItemRecyAdapter(title,imageId)
        binding.departmentItemRecy.apply {
            adapter = departmentAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }

        priorityAdapter = DepartmentItemRecyAdapter(priorityTitle,priorityImageId)
        binding.priorityItemRecy.apply {
            adapter = priorityAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }

        reservationAdapter = DepartmentItemRecyAdapter(reservationTitle,reservationImageId)
        binding.reservationItemRecy.apply {
            adapter = reservationAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

}