package com.example.xtreamclean.ui.userUiFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.innobuzztask.utils.Resource
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.xtreamclean.MainActivity
import com.example.xtreamclean.R
import com.example.xtreamclean.adapter.MyHistory_TaskRecyAdapter
import com.example.xtreamclean.adapter.ViewPagerAdapter
import com.example.xtreamclean.adapter.userUIAdapters.ServicesParentRecyAdapter
import com.example.xtreamclean.databinding.FragmentHomeBinding
import com.example.xtreamclean.databinding.FragmentUserHomeBinding
import com.google.android.material.tabs.TabLayoutMediator


class userHomeFragment : Fragment() {

    private lateinit var binding: FragmentUserHomeBinding
    private lateinit var mAdapter: ServicesParentRecyAdapter
    private lateinit var viewModel : DataViewModel

    val servicesTitle = listOf<String>("Holiday exit cleaning","Linen hire services","Carpet cleaning service",)
    val imageId = listOf<Int>(
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
        binding = FragmentUserHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })
        viewModel = (activity as MainActivity).viewModel

        mAdapter = ServicesParentRecyAdapter(servicesTitle,imageId,requireActivity())

        binding.servicesRecy.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.logoutBtn.setOnClickListener {
            viewModel.logoutUserDataResponse("1")
            observeUserLogout()
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
//                    findNavController().navigate(R.id.userHomeFragment)
                }
                R.id.offerBtn -> {
//                    findNavController().navigate(R.id.offerFragment)
                }
                R.id.myHistoryBtn -> {
//                    findNavController().navigate(R.id.myHistoryFragment)
                }

            }
            true
        }
    }
    private fun observeUserLogout() {
        viewModel.getData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    if (it.data?.status.toString() == "success"){
                        findNavController().navigate(R.id.action_userHomeFragment_to_loginFragment)
                    }else{
                        Toast.makeText(requireContext(), "Unable to logout", Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Error -> {
                }
            }
        })
    }


}
