package com.example.kyros.sphsfoodapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Kyros on 2/17/2018.
 */
class FoodFragmentPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    val fragments = arrayOf<Fragment>(MenuFragment(), CheckOutFragment(), AccountFragment())

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}