package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arshman.i222427.adapters.StoryAdapter
import com.arshman.i222427.databinding.ActivityHomeBinding
import com.arshman.i222427.models.Story
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var storyAdapter: StoryAdapter
    private lateinit var storyList: ArrayList<Story>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root) // ✅ Corrected

        // Initialize Story List
        storyList = ArrayList()
        storyList.add(Story(R.drawable.profile1, "Emily"))
        storyList.add(Story(R.drawable.profile2, "Kadin"))
        storyList.add(Story(R.drawable.profile3, "Sophia"))
        storyList.add(Story(R.drawable.profile4, "Liam"))
        storyList.add(Story(R.drawable.profile_placeholder2, "Olivia"))

        // Set up RecyclerView
        binding.recyclerViewStories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storyAdapter = StoryAdapter(this, storyList)
        binding.recyclerViewStories.adapter = storyAdapter

        // DM Icon Click Listener
        binding.ivDM.setOnClickListener {
            val intent = Intent(this, DMActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.menu.findItem(R.id.nav_home).isChecked = true

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Log.d("HomeActivity", "Home Clicked")
                    true
                }

                R.id.nav_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_add -> {
                    startActivity(Intent(this, NewPostActivity::class.java))
                    true
                }

                R.id.nav_contacts -> {
                    val intent = Intent(this, ContactsActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false

            }
        }
    }
}
