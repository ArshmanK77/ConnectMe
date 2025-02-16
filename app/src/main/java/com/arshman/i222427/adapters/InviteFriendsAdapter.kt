package com.arshman.i222427.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.databinding.InviteFriendBinding
import com.arshman.i222427.models.Contact

class InviteFriendsAdapter(private val inviteList: List<Contact>) :
    RecyclerView.Adapter<InviteFriendsAdapter.InviteViewHolder>() {

    inner class InviteViewHolder(private val binding: InviteFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.tvName.text = contact.name
            binding.ivProfile.setImageResource(contact.profileImage)

            // Handle invite button click (e.g., show a toast, update UI)
            binding.btnInvite.setOnClickListener {
                // TODO: Implement invite logic
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InviteViewHolder {
        val binding = InviteFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InviteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InviteViewHolder, position: Int) {
        holder.bind(inviteList[position])
    }

    override fun getItemCount() = inviteList.size
}
