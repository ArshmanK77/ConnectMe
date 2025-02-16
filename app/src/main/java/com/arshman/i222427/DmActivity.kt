package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.adapters.DMAdapter
import com.arshman.i222427.models.DM

class DMActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dmAdapter: DMAdapter
    private lateinit var dmList: ArrayList<DM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dm)

        // Toolbar Back Button
        val toolbar: Toolbar = findViewById(R.id.dmToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish() // Close DMActivity
        }

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy Data
        dmList = arrayListOf(
            DM(R.drawable.henryb, "Henry Benjamin", false),
            DM(R.drawable.emilyj, "Emily James", true),
            DM(R.drawable.lilyt, "Lily Thomas", false),
            DM(R.drawable.christopher, "Christopher", false),
            DM(R.drawable.amyw, "Amy Wesley", false),
            DM(R.drawable.laurar, "Laura Ryan", false)
        )

        // Set Adapter
        dmAdapter = DMAdapter(this, dmList)
        recyclerView.adapter = dmAdapter
    }
}
