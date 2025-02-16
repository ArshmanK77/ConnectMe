package com.arshman.i222427.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.R
import com.arshman.i222427.models.Story

class StoryAdapter(private val context: Context, private val storyList: List<Story>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivStoryProfile: ImageView = itemView.findViewById(R.id.ivStoryProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = storyList[position]
        holder.ivStoryProfile.setImageResource(story.profileImage)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }
}