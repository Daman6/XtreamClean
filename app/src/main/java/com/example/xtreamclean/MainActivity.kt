package com.example.xtreamclean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.innobuzztask.repo.DataRepo
import com.example.innobuzztask.viewModel.DataViewModel
import com.example.innobuzztask.viewModel.DataViewModelProviderFactory
import com.example.xtreamclean.databinding.ActivityMainBinding
import com.example.xtreamclean.model.LoginResponse

class MainActivity : AppCompatActivity() {

//    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : DataViewModel
    private lateinit var list:MutableList<LoginResponse>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val repo = DataRepo()
        val viewModelProviderFactory = DataViewModelProviderFactory(repo)

        viewModel  = ViewModelProvider(this,viewModelProviderFactory).get(DataViewModel::class.java)

        list = mutableListOf()
        viewModel.getData.observe(this, Observer {

            Log.e("djbjsbd",it.data?.data?.email.toString())

        })

//        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
//        binding.drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//        setSupportActionBar(binding.appBar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        binding.navView.setNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.mytaskBtn -> Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show()
//                R.id.offerBtn -> Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show()
//                R.id.myHistoryBtn -> Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show()
//            }
//            true
//        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(toggle.onOptionsItemSelected(item)){
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
}