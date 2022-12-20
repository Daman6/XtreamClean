package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.ProductDetailViewPagerAdapter
import com.example.xtreamclean.adapter.PropertyDetailElementRecyAdapter
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.adapter.ViewPagerAdapter
import com.example.xtreamclean.databinding.FragmentHomeBinding
import com.example.xtreamclean.databinding.FragmentProductDetailBinding
import com.google.android.material.tabs.TabLayoutMediator


class ProductDetailFragment : Fragment() {


    private lateinit var binding: FragmentProductDetailBinding
    val tabTitles = arrayOf(
        "Overview", "Element"
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
        binding = FragmentProductDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupViewPager()
        setupTabLayout()

        binding.hamMenuBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
    private fun setupViewPager() {
        val adapter = ProductDetailViewPagerAdapter(requireActivity(), 2)
        binding.viewPager.adapter = adapter
    }

}