package alaiz.hashim.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

lateinit var drawerLayout: DrawerLayout
lateinit var navView: NavigationView
lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        actionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }

        }
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.starred -> {
                    Toast.makeText(this, "starred is clicked", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.recent -> {
                    Toast.makeText(this, "recent is clicked", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.upload -> {
                    Toast.makeText(this, "upload is clicked", Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
}