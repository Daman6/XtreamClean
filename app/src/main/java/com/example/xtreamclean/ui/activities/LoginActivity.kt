package com.example.xtreamclean.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.innobuzztask.repo.DataRepo
import com.example.innobuzztask.utils.Resource
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.innobuzztask.viewModel.DataViewModelProviderFactory
import com.example.xtreamclean.MainActivity
import com.example.xtreamclean.R
import com.example.xtreamclean.databinding.ActivityLoginBinding
import com.example.xtreamclean.utils.SavedPreference

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var viewModel : DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = DataRepo()
        val viewModelProviderFactory = DataViewModelProviderFactory(repo)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(DataViewModel::class.java)

        var session = SavedPreference.getSession(this).toString()
        Log.e("dbkabk",session.toString())

        if(session =="LoggedIn"){

            startActivity(Intent(this,MainActivity::class.java))
//            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
//        if (session == "LoggedOut"){
//            startActivity(Intent(this,LoginActivity::class.java))
//        }


//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                requireActivity().finish()
//            }
//
//        })
//        (activity as MainActivity).onBackPressed().apply {
//            Toast.makeText(requireContext(), "back", Toast.LENGTH_SHORT).show()
//        }

        binding.signInBtn.setOnClickListener {
            binding.progessBar.visibility = View.VISIBLE
            binding.signInText.visibility = View.INVISIBLE
            checkUserDetails()

        }
        binding.forgetPass.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_forgetFragment)
        }

        binding.signUp.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
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
        viewModel.getData.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    if (it.data?.status.toString() == "success"){
                        if (it.data?.data?.role.toString() == "U"){
                            SavedPreference.setSession(this,"LoggedIn")
//                            findNavController().navigate(R.id.action_loginFragment_to_userHomeFragment)
                            startActivity(Intent(this,MainActivity::class.java))

                            binding.progessBar.visibility = View.INVISIBLE
                            binding.signInText.visibility = View.VISIBLE
                        }else{
                            SavedPreference.setSession(this,"LoggedIn")
//                            findNavController().navigate(R.id.action_loginFragment_to_userHomeFragment)
                            startActivity(Intent(this,MainActivity::class.java))
                            binding.progessBar.visibility = View.INVISIBLE
                            binding.signInText.visibility = View.VISIBLE
                        }
                    }else{
                        Toast.makeText(this, "" + it.data?.result.toString(), Toast.LENGTH_SHORT).show()
                        binding.progessBar.visibility = View.INVISIBLE
                        binding.signInText.visibility = View.VISIBLE
                    }
                }

                is Resource.Error -> {
                    Toast.makeText(this, "" + it.data?.result.toString(), Toast.LENGTH_SHORT).show()
                    binding.progessBar.visibility = View.INVISIBLE
                    binding.signInText.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        this.finishAffinity()

    }
}