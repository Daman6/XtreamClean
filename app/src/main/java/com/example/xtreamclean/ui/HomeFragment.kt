package com.example.xtreamclean.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.util.Pair
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.xtreamclean.MainActivity
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.TaskRecyAdapter
import com.example.xtreamclean.adapter.ViewPagerAdapter
import com.example.xtreamclean.databinding.FragmentHomeBinding
import com.example.xtreamclean.model.LoginResponse
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.INPUT_MODE_CALENDAR
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: TaskRecyAdapter
    private lateinit var mList: List<Int>

    private var outputDateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
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

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })

//        mList = listOf(1, 2, 3)
//        mAdapter = TaskRecyAdapter(mList)




//        binding.taskRecy.apply {
//            adapter = mAdapter
//            layoutManager = LinearLayoutManager(requireContext())
//        }

        binding.sortByBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_customBottomSheetDialogFragment)

        }

        binding.bottomBtnClick.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_headerBottomFragment)
        }

        binding.calendarIcon.setOnClickListener {
            setUpDatePicker()
        }

        setupViewPager()
        setupTabLayout()
        setUpNavMenu()
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



    private fun setUpDatePicker(){
        val calendarConstraintBuilder = CalendarConstraints.Builder()
        calendarConstraintBuilder.setValidator(DateValidatorPointForward.now())



        val picker = MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText("Select Date")
            .setCalendarConstraints(calendarConstraintBuilder.build())
            .setSelection(Pair( MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds()))
            .build()

        picker.addOnPositiveButtonClickListener {
            val dateSelected = outputDateFormat.format(it.first)
            val seconddateSelected = outputDateFormat.format(it.second)
            Toast.makeText(requireContext(), dateSelected +"----"+seconddateSelected, Toast.LENGTH_SHORT).show()
        }
        picker.addOnNegativeButtonClickListener {
            Toast.makeText(requireContext(), "No Date Selected", Toast.LENGTH_SHORT).show()
        }
        picker.show(requireActivity().supportFragmentManager,"Date Picker")
    }

}