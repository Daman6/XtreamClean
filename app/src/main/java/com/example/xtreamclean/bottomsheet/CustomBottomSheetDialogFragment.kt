package com.example.xtreamclean.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.SortbyBottomsheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object{
        const val TAG = "CustomBottomSheetDialogFragment"
    }

    private lateinit var binding: SortbyBottomsheetLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SortbyBottomsheetLayoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addressBtn.setOnClickListener {
            //handle click event
            Toast.makeText(context, "First Button Clicked", Toast.LENGTH_SHORT).show()
        }
//        secondButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "Second Button Clicked", Toast.LENGTH_SHORT).show()
//        }
//        thirdButton.setOnClickListener {
//            //handle click event
//            Toast.makeText(context, "Third Button Clicked", Toast.LENGTH_SHORT).show()
//        }
    }

}