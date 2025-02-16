package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class UploadPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_post)

        val ivClose: ImageView = findViewById(R.id.ivClose)
        val btnShare: Button = findViewById(R.id.btnShare)
        val etCaption: EditText = findViewById(R.id.etCaption)

        // Close button functionality
        ivClose.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Share button functionality
        btnShare.setOnClickListener {
            val captionText = etCaption.text.toString().trim()
            if (captionText.isNotEmpty()) {
                Toast.makeText(this, "Post Shared!", Toast.LENGTH_SHORT).show()
                finish() // Simulating post upload
            } else {
                Toast.makeText(this, "Please add a caption!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
