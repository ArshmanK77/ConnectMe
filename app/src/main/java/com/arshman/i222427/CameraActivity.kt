package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {

    private lateinit var ivBack: ImageView
    private lateinit var tvNext: TextView
    private lateinit var ivPicButtton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        ivBack = findViewById(R.id.ivClose)
        tvNext = findViewById(R.id.tvNext)
        ivPicButtton = findViewById(R.id.btnCapture)

        ivBack.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        tvNext.setOnClickListener {
            intent = Intent(this, UploadPostActivity::class.java)
            startActivity(intent)
        }

        ivPicButtton.setOnClickListener {
            intent = Intent(this, UploadPostActivity::class.java)
            startActivity(intent)
        }
    }
}
