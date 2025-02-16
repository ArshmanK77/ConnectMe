package com.arshman.i222427

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)  // Make sure this matches your XML filename

        findViewById<TextView>(R.id.tvDone).setOnClickListener {
            finish()  // Close the EditProfileActivity and return to the ProfileActivity
        }
    }
}
