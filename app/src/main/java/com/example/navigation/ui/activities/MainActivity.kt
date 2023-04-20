package com.example.navigation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigation.R
import com.example.navigation.databinding.ActivityMainBinding
import java.security.AccessController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initNavigator()
        initListeners()

    }

    private fun initNavigator() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController //ayuda a controlar la navegación
    }

    private fun initListeners() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuItem_Notes -> {
                    navController.navigate(R.id.actionToNotes)
                }
                R.id.menuItem_Tasks -> {
                    navController.navigate(R.id.actionToTasks)
                }
                R.id.menuItem_home -> {
                    navController.popBackStack(R.id.homeFragment, false)
                }
            }
            true
        }

    }

}