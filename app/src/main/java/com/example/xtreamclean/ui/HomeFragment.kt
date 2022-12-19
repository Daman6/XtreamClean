package com.example.xtreamclean.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.adapter.ViewPagerAdapter
import com.example.xtreamclean.bottomsheet.CustomBottomSheetDialogFragment
import com.example.xtreamclean.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: TaskRecyAdapter
    private lateinit var mList: List<Int>
    private lateinit var sheetDailod: BottomSheetDialog
    val tabTitles = arrayOf(
        "Today", "Tomorrow", "Week", "All"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mList = listOf(1, 2, 3)
        mAdapter = TaskRecyAdapter(mList)

//        binding.taskRecy.apply {
//            adapter = mAdapter
//            layoutManager = LinearLayoutManager(requireContext())
//        }

        binding.sortByBtn.setOnClickListener {

//            sheetDailod = BottomSheetDialog(requireContext(),R.style.BottomSheeStyle)
//            val view = LayoutInflater.from(requireContext()).inflate(R.layout.sortby_bottomsheet_layout)

            findNavController().navigate(R.id.action_homeFragment_to_customBottomSheetDialogFragment)
//                CustomBottomSheetDialogFragment().apply {
//                    show(parentFragmentManager, CustomBottomSheetDialogFragment.TAG)
//            }
        }

        binding.bottomBtnClick.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_headerBottomFragment)
        }

        setupViewPager()
        setupTabLayout()


        binding.hamMenuBtn.setOnClickListener {
            if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) binding.drawerLayout.openDrawer(
                GravityCompat.START
            );
            else binding.drawerLayout.closeDrawer(GravityCompat.END);

        }




        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mytaskBtn -> Toast.makeText(requireContext(), "Item1", Toast.LENGTH_SHORT)
                    .show()
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

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }


    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(requireActivity(), 4)
        binding.viewPager.adapter = adapter
    }

}