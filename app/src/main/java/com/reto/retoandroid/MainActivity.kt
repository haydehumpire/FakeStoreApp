package com.reto.retoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.reto.retoandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!.findNavController()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
