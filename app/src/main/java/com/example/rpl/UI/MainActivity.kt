package com.example.rpl.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.rpl.R
import com.example.rpl.UI.Home.HomeFragment
import com.example.rpl.UI.Plus.PlusFragment
import com.example.rpl.UI.Profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initiateUi()
    }

    private fun initiateUi(){
        loadFragment(HomeFragment())
        BottomNavigation.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bnv_home -> loadFragment(
                HomeFragment()
            )
            R.id.bnv_plus -> loadFragment(
                PlusFragment()
            )
            R.id.bnv_profile -> loadFragment(
                ProfileFragment()
            )
        }
        return true
    }
}