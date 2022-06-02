package com.example.whatsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.core.graphics.alpha
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.time.toDuration

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myToolBar.title = "WhatsApp"
        setSupportActionBar(myToolBar)
        tabLayout.setTabTextColors(Color.parseColor("#7CFFFFFF"), Color.parseColor("#FFFFFFFF"))


        var viewPagerAdapter = viewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(CallsFragment(), "CALLS")
        viewPagerAdapter.addFragment(ChatsFragment(), "CHATS")
        viewPagerAdapter.addFragment(StatusFragment(), "STATUS")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        button.setOnClickListener { startSupportActionMode(contextualMenu()) }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.whatsapp_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.searchWhat) {
            myToolBar.animate().alpha(0f).duration = 0
            myToolBar.visibility = View.GONE
            tabLayout.visibility = View.GONE
            search_bar.visibility = View.VISIBLE
            search_back.setOnClickListener {
                search_bar.visibility = View.GONE
                myToolBar.visibility = View.VISIBLE
                tabLayout.visibility = View.VISIBLE
                myToolBar.animate().alpha(1f).duration = 200
            }
        } else {
            Toast.makeText(applicationContext, "${item.title}", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    inner class contextualMenu : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.contextual_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.setTitle("Contextual Menu")
            return true
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            TODO("Not yet implemented")
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            mode?.finish()
        }

    }

}