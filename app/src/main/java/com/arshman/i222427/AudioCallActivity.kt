package com.arshman.i222427

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arshman.i222427.databinding.ActivityAudioCallBinding

class AudioCallActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAudioCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // End call when button is clicked
        binding.endCallButton.setOnClickListener {
            finish() // Close activity
        }
    }
}
