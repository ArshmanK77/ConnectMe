package com.arshman.i222427

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VideoCallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)

        val endCallButton: ImageView = findViewById(R.id.endCallButton)

        // End call and return to chat screen
        endCallButton.setOnClickListener {
            finish()
        }
    }
}
