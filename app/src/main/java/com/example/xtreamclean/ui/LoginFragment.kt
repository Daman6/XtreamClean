package com.example.xtreamclean.ui

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.innobuzztask.api.dataApi
import com.example.innobuzztask.utils.Resource
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.xtreamclean.MainActivity
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.FragmentHomeBinding
import com.example.xtreamclean.databinding.FragmentLoginBinding
import com.example.xtreamclean.model.LoginResponse


class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private lateinit var viewModel : DataViewModel
    private lateinit var list:MutableList<LoginResponse>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })
//        (activity as MainActivity).onBackPressed().apply {
//            Toast.makeText(requireContext(), "back", Toast.LENGTH_SHORT).show()
//        }

        binding.signInBtn.setOnClickListener {
            binding.progessBar.visibility = View.VISIBLE
            binding.signInText.visibility = View.INVISIBLE
            checkUserDetails()

        }
        binding.forgetPass.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgetFragment)
        }

        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

    }

    private fun checkUserDetails() {

        binding.emailEditText.text.toString()
        binding.passwordEditText.text.toString()


        if (binding.emailEditText.text.isEmpty()){
            binding.emailEditText.error = "Please Enter email"
            binding.progessBar.visibility = View.INVISIBLE
            binding.signInText.visibility = View.VISIBLE
            return
        }

        if (binding.passwordEditText.text.isEmpty()){
            binding.passwordEditText.error = "Please Enter Password"
            binding.progessBar.visibility = View.INVISIBLE
            binding.signInText.visibility = View.VISIBLE
            return
        }

        viewModel.getDataResponse(binding.emailEditText.text.toString(),binding.passwordEditText.text.toString())
        observeUserLogin()

    }
//    private fun isValidEmail(email: String): Boolean {
//        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
//    }

    private fun observeUserLogin() {
        viewModel.getData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    if (it.data?.status.toString() == "success"){
                        if (it.data?.data?.role.toString() == "U"){
                            findNavController().navigate(R.id.action_loginFragment_to_userHomeFragment)
                            binding.progessBar.visibility = View.INVISIBLE
                            binding.signInText.visibility = View.VISIBLE
                        }else{
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                            binding.progessBar.visibility = View.INVISIBLE
                            binding.signInText.visibility = View.VISIBLE
                        }
                    }else{
                        Toast.makeText(requireContext(), "" + it.data?.result.toString(), Toast.LENGTH_SHORT).show()
                        binding.progessBar.visibility = View.INVISIBLE
                        binding.signInText.visibility = View.VISIBLE
                    }
                }

                is Resource.Error -> {
                    Toast.makeText(requireContext(), "" + it.data?.result.toString(), Toast.LENGTH_SHORT).show()
                    binding.progessBar.visibility = View.INVISIBLE
                    binding.signInText.visibility = View.VISIBLE
                }
            }
        })
    }



}