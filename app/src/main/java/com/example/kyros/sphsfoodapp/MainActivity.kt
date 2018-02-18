package com.example.kyros.sphsfoodapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var currentItem = -1
        when (item.itemId) {
            R.id.menu_item -> {
                currentItem = 0
            }
            R.id.check_out_item -> {
                currentItem = 1
            }
            R.id.account_item -> {
                currentItem = 2
            }
            else -> return@OnNavigationItemSelectedListener false
        }
        fragmentViewPager.setCurrentItem(currentItem, false)
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //user selects fragment from tab
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //viewpager setup
        fragmentViewPager.adapter = FoodFragmentPagerAdapter(supportFragmentManager)
        fragmentViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                //nothing
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                //nothing
            }

            override fun onPageSelected(position: Int) {
                navigation.menu.getItem(position).setChecked(true)
            }

        })
    }
}
