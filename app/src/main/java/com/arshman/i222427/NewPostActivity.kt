package com.arshman.i222427

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.adapters.GalleryAdapter

class NewPostActivity : AppCompatActivity() {

    private lateinit var rvGallery: RecyclerView
    private lateinit var ivBack: ImageView
    private lateinit var tvNext: TextView
    private lateinit var ivCamera: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        ivBack = findViewById(R.id.ivBack)
        tvNext = findViewById(R.id.tvNext)
        rvGallery = findViewById(R.id.rvGallery)
        ivCamera = findViewById(R.id.ivCamera)


        ivBack.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        tvNext.setOnClickListener {
            intent = Intent(this, UploadPostActivity::class.java)
            startActivity(intent)
        }

        ivCamera.setOnClickListener {
            intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        // Set up RecyclerView (dummy data for now)
        rvGallery.layoutManager = GridLayoutManager(this, 3)
        rvGallery.adapter = GalleryAdapter(getDummyImages())
    }

    private fun getDummyImages(): List<Int> {
        return listOf(
            R.drawable.sample_post_image, R.drawable.sample_post_image, R.drawable.sample_post_image,
            R.drawable.sample_post_image, R.drawable.sample_post_image, R.drawable.sample_post_image,
            R.drawable.sample_post_image, R.drawable.sample_post_image, R.drawable.sample_post_image
        )
    }
}
