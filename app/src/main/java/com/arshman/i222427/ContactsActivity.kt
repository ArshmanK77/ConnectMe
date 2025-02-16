package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arshman.i222427.R
import com.arshman.i222427.adapters.ContactsAdapter
import com.arshman.i222427.adapters.InviteFriendsAdapter
import com.arshman.i222427.databinding.ActivityContactsBinding
import com.arshman.i222427.models.Contact
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactsBinding
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var inviteAdapter: InviteFriendsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerViews()
        setupListeners()

        // Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.menu.findItem(R.id.nav_contacts).isChecked = true

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.nav_search -> {
                    intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_add -> {
                    startActivity(Intent(this, NewPostActivity::class.java))
                    true
                }
                R.id.nav_contacts -> {
                    Log.d("ContactsActivity", "Contacts Clicked")
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerViews() {
        // Sample data
        val contactsList = listOf(
            Contact("Henry School", R.drawable.henryb, true),
            Contact("Emily James", R.drawable.emilyj, true),
            Contact("Lily Thomas", R.drawable.lilyt, true)
        )

        val inviteList = listOf(
            Contact("Amy Wesley", R.drawable.amyw, false),
            Contact("Laura Ryan", R.drawable.laurar, false),
            Contact("Christopher", R.drawable.christopher, false)
        )

        // Setup Contacts RecyclerView
        contactsAdapter = ContactsAdapter(contactsList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactsAdapter

        // Setup Invite Friends RecyclerView
        inviteAdapter = InviteFriendsAdapter(inviteList)
        binding.rvInviteFriends.layoutManager = LinearLayoutManager(this)
        binding.rvInviteFriends.adapter = inviteAdapter
    }

    private fun setupListeners() {
        binding.ivBack.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
