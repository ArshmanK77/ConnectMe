package com.arshman.i222427

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arshman.i222427.databinding.ActivityVanishModeBinding
import com.arshman.i222427.adapters.ChatAdapter
import com.arshman.i222427.databinding.ActivityChatBinding
import com.arshman.i222427.models.ChatMessage

class VanishModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVanishModeBinding
    private lateinit var gestureDetector: GestureDetector
    private lateinit var vanishAdapter: ChatAdapter  // Adapter for messages
    private val messageList = mutableListOf<ChatMessage>() // Temporary message storage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVanishModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize swipe gesture detector
        gestureDetector = GestureDetector(this, SwipeGestureListener())

        // Back button functionality
        binding.backButton.setOnClickListener {
            finish()  // Closes Vanish Mode and goes back to DM screen
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Dummy messages (Static for UI)
        messageList.add(ChatMessage("Hello, How are you?", "10:30 AM", false))
        messageList.add(ChatMessage("Hi, I am great, Wbu?", "10:32 AM", true))
        messageList.add(ChatMessage("I am doing well", "1:30 PM", false))
        messageList.add(ChatMessage("Good to know", "1:30 PM", true))
        messageList.add(ChatMessage("There is something IMP you should know", "10:30 AM", false))

        // Set adapter
        vanishAdapter = ChatAdapter(messageList)
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.chatRecyclerView.adapter = vanishAdapter
    }

    // Ensure gestures are properly detected
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            return gestureDetector.onTouchEvent(it) || super.onTouchEvent(it)
        }
        return super.onTouchEvent(null)
    }

    // Swipe Gesture Listener
    inner class SwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e1 != null && e2 != null) {
                val deltaY = e1.y - e2.y
                if (deltaY > 150) { // Swipe up detected
                    startActivity(Intent(this@VanishModeActivity, ChatActivity::class.java))
                    overridePendingTransition(R.anim.slide_up, R.anim.fade_in)
                    finish()
                    return true
                }
            }
            return false
        }
    }
}

