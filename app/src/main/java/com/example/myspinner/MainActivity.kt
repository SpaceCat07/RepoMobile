package com.example.myspinner

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myspinner.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(R.string.tab_txt_1, R.string.tab_txt_2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter

        val tabs : TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabs, viewPager) {
            tab, position ->
            tab.text = resources.getString(TAB_TITLE[position])
        }.attach()
    }
}