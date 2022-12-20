package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.ElementDetailViewPagerAdapter
import com.example.xtreamclean.adapter.ProductDetailViewPagerAdapter
import com.example.xtreamclean.databinding.FragmentElementDetailBinding
import com.example.xtreamclean.databinding.FragmentProductDetailBinding
import com.google.android.material.tabs.TabLayoutMediator


class ElementDetailFragment : Fragment() {


    private lateinit var binding: FragmentElementDetailBinding
    val tabTitles = arrayOf(
        "OVERVIEW", "ABOUT"
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
        binding = FragmentElementDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        setupViewPager()
        setupTabLayout()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
    private fun setupViewPager() {
        val adapter = ElementDetailViewPagerAdapter(requireActivity(), 2)
        binding.viewPager.adapter = adapter
    }

}