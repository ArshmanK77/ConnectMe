package com.arshman.i222427

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.arshman.i222427.adapters.FollowersPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FollowersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers)  // ✅ Keep it the same as before

        // ✅ Find views using findViewById instead of View Binding
        val backButton = findViewById<ImageView>(R.id.backButton)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // ✅ Fix: Set back button functionality
        backButton.setOnClickListener {
            finish() // ✅ Closes FollowersActivity and returns to Profile Page
        }

        // ✅ Keep ViewPager and TabLayout setup the same
        viewPager.adapter = FollowersPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position == 0) "Followers" else "Following"
        }.attach()
    }
}
