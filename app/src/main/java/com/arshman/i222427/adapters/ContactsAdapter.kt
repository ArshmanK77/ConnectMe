package com.arshman.i222427.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.databinding.ItemContactBinding
import com.arshman.i222427.models.Contact

class ContactsAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.tvName.text = contact.name
            binding.ivProfile.setImageResource(contact.profileImage) // Ensure correct profile image
            binding.ivChat.visibility = if (contact.isInContacts) View.VISIBLE else View.GONE // Ensure chat icon visibility

            // Make "Emily James" bold
            if (contact.name.equals("Emily James", ignoreCase = true)) {
                binding.tvName.setTypeface(null, android.graphics.Typeface.BOLD)
            } else {
                binding.tvName.setTypeface(null, android.graphics.Typeface.NORMAL)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position]) // Now calling bind() correctly
    }

    override fun getItemCount(): Int = contacts.size
}
