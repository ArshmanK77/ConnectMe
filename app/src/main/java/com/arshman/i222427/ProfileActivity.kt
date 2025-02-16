package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.adapters.ProfileAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    private lateinit var postList: ArrayList<Int>
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)  // Ensure the correct layout is used

        // Initialize Post List
        postList = arrayListOf(
            R.drawable.post1, R.drawable.post2, R.drawable.post3,
            R.drawable.post4, R.drawable.post5, R.drawable.post6, R.drawable.post7
        )

        // Set up RecyclerView
        val recyclerViewPosts = findViewById<RecyclerView>(R.id.recyclerViewPosts)
        profileAdapter = ProfileAdapter(this, postList)
        recyclerViewPosts.layoutManager = GridLayoutManager(this, 3)
        recyclerViewPosts.adapter = profileAdapter

        // Followers Click Listener
        findViewById<TextView>(R.id.followersTextView).setOnClickListener {
            startActivity(Intent(this, FollowersActivity::class.java))
        }

        // Following Click Listener
        findViewById<TextView>(R.id.followingTextView).setOnClickListener {
            startActivity(Intent(this, FollowersActivity::class.java))
        }

        // Edit Profile Click Listener
        findViewById<ImageView>(R.id.editProfileIcon).setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

        // Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.menu.findItem(R.id.nav_profile).isChecked = true

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }
                R.id.nav_add -> {
                    startActivity(Intent(this, NewPostActivity::class.java))
                    true
                }
                R.id.nav_contacts -> {
                    startActivity(Intent(this, ContactsActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    Log.d("ProfileActivity", "Profile Clicked")
                    true
                }
                else -> false
            }
        }
    }
}
