package com.arshman.i222427.models

data class ChatMessage(
    val text: String,
    val time: String,
    val isReceived: Boolean // Add this field
)
