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

class FollowingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_following, container, false)

        // Dummy list of following users
        val followingList = listOf(
            Follower("John Doe", R.drawable.saad_s),
            Follower("Emma Watson", R.drawable.saad_s),
            Follower("Robert Brown", R.drawable.saad_s),
            Follower("Sophia Wilson", R.drawable.saad_s),
            Follower("Michael Johnson", R.drawable.saad_s),
            Follower("Olivia Smith", R.drawable.saad_s)
        )

        // Set up RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFollowing)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = FollowersListAdapter(followingList)

        return view
    }
}
