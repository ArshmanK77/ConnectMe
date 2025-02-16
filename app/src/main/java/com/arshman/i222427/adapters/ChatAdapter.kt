package com.arshman.i222427.adapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.R
import com.arshman.i222427.models.ChatMessage

class ChatAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.text)
        val timeText: TextView = itemView.findViewById(R.id.time)
        val messageContainer: LinearLayout = itemView.findViewById(R.id.messageContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatMessage = messages[position]

        holder.messageText.text = chatMessage.text
        holder.timeText.text = chatMessage.time

        val layoutParams = holder.messageContainer.layoutParams as LinearLayout.LayoutParams

        if (chatMessage.isReceived) {
            // Left align for received messages
            layoutParams.gravity = Gravity.START
            holder.messageContainer.setBackgroundResource(R.drawable.message_received_bg)
        } else {
            // Right align for sent messages
            layoutParams.gravity = Gravity.END
            holder.messageContainer.setBackgroundResource(R.drawable.message_sent_bg)
        }

        holder.messageContainer.layoutParams = layoutParams // Apply changes
    }


    override fun getItemCount(): Int = messages.size
}
