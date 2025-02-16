package com.arshman.i222427.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arshman.i222427.R
import com.arshman.i222427.adapters.FollowersListAdapter
import com.arshman.i222427.models.Follower

class FollowersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_followers, container, false)

        // Dummy list of followers
        val followersList = listOf(
            Follower("Saad Salman", R.drawable.saad_s),
            Follower("Emily James", R.drawable.saad_s),
            Follower("Lily Thomas", R.drawable.saad_s),
            Follower("Christopher", R.drawable.saad_s)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = FollowersListAdapter(followersList)

        return view
    }
}
