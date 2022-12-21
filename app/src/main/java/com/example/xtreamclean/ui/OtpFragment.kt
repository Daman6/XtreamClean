package com.example.xtreamclean.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.FragmentOtpBinding
import com.example.xtreamclean.databinding.FragmentRegistrationBinding


class OtpFragment : Fragment() {


    private lateinit var binding : FragmentOtpBinding



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
        binding = FragmentOtpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verifyBtn.setOnClickListener {
            findNavController().navigate(R.id.action_otpFragment_to_homeFragment)
        }

        val number = "9953595635";
        val mask = number.replace("\\w(?=\\w{2})".toRegex(),"*")


        binding.phoneNoTV.setText(mask);
    }
}