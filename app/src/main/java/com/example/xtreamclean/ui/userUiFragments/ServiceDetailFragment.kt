package com.example.xtreamclean.ui.userUiFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.FragmentServiceDetailBinding

class ServiceDetailFragment : Fragment() {

    private lateinit var binding : FragmentServiceDetailBinding
    private lateinit var service_Title :  String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           service_Title = requireArguments().getString("service_title").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServiceDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://bit.ly/2YoJ77H"))
        imageList.add(SlideModel("https://bit.ly/3fLJf72"))
        imageList.add(SlideModel("https://bit.ly/3fLJf72"))
        binding.imageSlider.setImageList(imageList)

        binding.serviceNameT.text = service_Title

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }



}