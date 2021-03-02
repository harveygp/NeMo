package com.example.rpl.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.example.rpl.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var plusFragment: PlusFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomnav : BottomNavigationView = findViewById<BottomNavigationView>(R.id.BottomNavigation)
        var frame : FrameLayout = findViewById<FrameLayout>(R.id.frameLayout)


        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        bottomnav.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.bnv_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.bnv_plus -> {
                    plusFragment = PlusFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, plusFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.bnv_profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
        }
    }
}