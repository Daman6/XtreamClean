package com.example.xtreamclean.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.innobuzztask.utils.Resource
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.xtreamclean.MainActivity
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.FragmentHeaderBottomBinding
import com.example.xtreamclean.ui.activities.LoginActivity
import com.example.xtreamclean.utils.SavedPreference


class HeaderBottomFragment : Fragment() {

    private lateinit var binding : FragmentHeaderBottomBinding
    private lateinit var viewModel : DataViewModel

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
        binding = FragmentHeaderBottomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        binding.labsTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_headerBottomFragment_to_labsFragment)
        }
        binding.notificationTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_headerBottomFragment_to_notificationFragment)
        }
        binding.profileTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_headerBottomFragment_to_profileFragment)
        }
        binding.supportTextLayout.setOnClickListener {
            findNavController().navigate(R.id.action_headerBottomFragment_to_chatFragment)
        }
        binding.signoutTextLayout.setOnClickListener {
            SavedPreference.setSession(requireContext(),"LoggedOut")
            startActivity(Intent(requireContext(),LoginActivity::class.java))
//
//            Toast.makeText(requireContext(), SavedPreference.getSession(requireContext()), Toast.LENGTH_SHORT).show()
            viewModel.logoutUserDataResponse("1")
            observeUserLogout()
        }



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
                    findNavController().navigate(R.id.offerFragment)
                }
                R.id.myHistoryBtn -> {
                    findNavController().navigate(R.id.myHistoryFragment)
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
//                        SavedPreference.setSession(requireContext(),"LoggedOut")
//                        startActivity(Intent(requireContext(),LoginActivity::class.java))

//                        Toast.makeText(requireContext(), SavedPreference.getSession(requireContext()), Toast.LENGTH_SHORT).show()

//                        SavedPreference.setSession(requireContext(),"LoggedOut")
                        Toast.makeText(requireContext(), "logout", Toast.LENGTH_SHORT).show()
//                        startActivity(Intent(requireContext(),LoginActivity::class.java))

//                        startActivity(Intent(requireContext(),LoginActivity::class.java))
////                        findNavController().navigate(R.id.action_headerBottomFragment_to_loginFragment)
//                        SavedPreference.setSession(requireContext(),"LoggedOut")

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