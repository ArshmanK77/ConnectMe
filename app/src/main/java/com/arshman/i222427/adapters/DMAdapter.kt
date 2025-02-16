package com.arshman.i222427.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.ChatActivity
import com.arshman.i222427.R
import com.arshman.i222427.models.DM

class DMAdapter(private val context: Context, private val dmList: List<DM>) :
    RecyclerView.Adapter<DMAdapter.DMViewHolder>() {

    inner class DMViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        val name: TextView = itemView.findViewById(R.id.name)
        val cameraIcon: ImageView = itemView.findViewById(R.id.cameraIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DMViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dm, parent, false)
        return DMViewHolder(view)
    }

    override fun onBindViewHolder(holder: DMViewHolder, position: Int) {
        val dm = dmList[position]
        holder.profileImage.setImageResource(dm.profileImage)
        holder.name.text = dm.name

        if (dm.isHighlighted) {
            holder.name.setTypeface(null, Typeface.BOLD)
        } else {
            holder.name.setTypeface(null, Typeface.NORMAL)
        }

        holder.itemView.setOnClickListener {
            Log.d("DMAdapter", "Clicked on: ${dm.name}")
            if (dm.name == "Henry Benjamin") {
                val intent = Intent(holder.itemView.context, ChatActivity::class.java)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = dmList.size
}
