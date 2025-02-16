package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arshman.i222427.adapters.ChatAdapter
import com.arshman.i222427.databinding.ActivityChatBinding
import com.arshman.i222427.models.ChatMessage

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var gestureDetector: GestureDetector
    private lateinit var chatAdapter: ChatAdapter
    private val messages = mutableListOf<ChatMessage>() // Store messages

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize gesture detector
        gestureDetector = GestureDetector(this, SwipeGestureListener())

        binding.backButton.setOnClickListener {
            finish() // Closes Vanish Mode and goes back to DM screen
        }

        binding.callButton.setOnClickListener {
            startActivity(Intent(this, AudioCallActivity::class.java))
        }

        binding.videoButton.setOnClickListener {
            startActivity(Intent(this, VideoCallActivity::class.java))
        }


        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Dummy messages (Static for UI)
        messages.add(ChatMessage("Hello, How are you?", "10:30 AM", false))
        messages.add(ChatMessage("Hi, I am great, Wbu?", "10:32 AM", true))
        messages.add(ChatMessage("I am doing well", "1:30 PM", false))
        messages.add(ChatMessage("Good to know", "1:30 PM", true))

        // Set adapter
        chatAdapter = ChatAdapter(messages)
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.chatRecyclerView.adapter = chatAdapter
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            return gestureDetector.onTouchEvent(it) || super.onTouchEvent(it)
        }
        return super.onTouchEvent(null)
    }

    inner class SwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e1 != null && e2 != null) {
                val deltaY = e2.y - e1.y
                if (deltaY > 150) { // Swipe down detected
                    startActivity(Intent(this@ChatActivity, VanishModeActivity::class.java))
                    overridePendingTransition(R.anim.slide_up, R.anim.fade_in)
                    return true
                }
            }
            return false
        }
    }
}
