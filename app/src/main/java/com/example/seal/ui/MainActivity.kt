package com.example.seal.ui

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.seal.R
import com.example.seal.databinding.ActivityMainBinding
import com.example.seal.ui.account.PersonalAccountFragment
import com.example.seal.ui.authorization.AuthorizationFragment
import com.example.seal.ui.cafes.CafeListFragment
import com.example.seal.ui.register.RegisterFragment
import com.example.seal.ui.scanner.ScannerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.cafiesMenu -> { openFragment(CafeListFragment()) }
                R.id.scanMenu -> { openFragment(ScannerFragment()) }
                R.id.accountMenu -> { openFragment(PersonalAccountFragment()) }
            }
            true
        }
    }

    private fun init() {
        val fragment = AuthorizationFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }

    override fun openFragment(fragment: Fragment, addToBackStack: Boolean?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment).apply {
                if(addToBackStack == true){
                    addToBackStack("")
                }
            }
            .commit()
    }
}