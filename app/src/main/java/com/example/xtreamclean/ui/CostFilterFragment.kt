package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.listadapter.DepartmentListAdapter
import com.example.xtreamclean.databinding.FragmentCostBinding
import com.example.xtreamclean.databinding.FragmentCostFilterBinding


class CostFilterFragment : Fragment() {

    private lateinit var binding : FragmentCostFilterBinding
    val title = arrayOf<String>("Clean","Inspection","Maintenace")
    val imageId = arrayOf<Int>(
        R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24,R.drawable.ic_outline_fact_check_24
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

//        val listAdapter = DepartmentListAdapter(requireActivity(),title,imageId)
//        binding.listItem1.apply {
//            adapter = listAdapter
//        }
        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }



    }

}