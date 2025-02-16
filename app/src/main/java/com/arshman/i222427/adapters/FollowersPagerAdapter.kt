package com.arshman.i222427.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arshman.i222427.fragments.FollowersFragment
import com.arshman.i222427.fragments.FollowingFragment

class FollowersPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2  // Two tabs: Followers & Following

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FollowersFragment()  // ✅ Ensure first tab loads FollowersFragment
            1 -> FollowingFragment()  // ✅ Ensure second tab loads FollowingFragment
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
