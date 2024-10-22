package com.example.myspinner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPagerAdapter(activity: AppCompatActivity, private val loginArgs:Bundle? = null) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment? = null

        when(position) {
            0 -> fragment = LoginFragment().apply { arguments = loginArgs }
            1 -> fragment = RegisterFragment().apply { arguments = loginArgs }
        }

        return fragment as Fragment
    }
}