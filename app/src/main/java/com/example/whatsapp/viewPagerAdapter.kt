package com.example.whatsapp

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class viewPagerAdapter(frM: FragmentManager) : FragmentPagerAdapter(frM) {

    var fragments = ArrayList<Fragment>()
    var tabTitle = ArrayList<String>()

    fun addFragment(fragment : Fragment , title : String){
        fragments.add(fragment)
        tabTitle.add(title)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitle[position]
    }
}