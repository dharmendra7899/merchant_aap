package com.example.myapplication.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.myapplication.R
import com.example.myapplication.fragments.AccountFragment
import com.example.myapplication.fragments.ChatFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.OrderFragment
import com.example.myapplication.fragments.ProductFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        if (savedInstanceState == null) {
            openFragment(HomeFragment())
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    openFragment(HomeFragment())
                    true
                }
                R.id.nav_product -> {
                    openFragment(ProductFragment())
                    true
                }
                R.id.nav_order -> {
                    openFragment(OrderFragment())
                    true
                }
                R.id.nav_chat -> {
                    openFragment(ChatFragment())
                    true
                } R.id.nav_account -> {
                openFragment(AccountFragment())
                true
            }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}