package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.FragmentLoginBinding
import com.example.xtreamclean.databinding.FragmentOtpBinding
import com.example.xtreamclean.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding : FragmentRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getOtpBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_otpFragment)
        }

        binding.signIn.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
    }

}