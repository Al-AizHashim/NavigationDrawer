package alaiz.hashim.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration



lateinit var drawerLayout: DrawerLayout
lateinit var navView: NavigationView
lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        //val fragment:Fragment

            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)


        actionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                drawerView.id
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
                    val fragment=StarredFragment.newInstance("","")
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    Toast.makeText(this, "starred is clicked", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.recent -> {
                    val fragment=RecentFragment.newInstance("","")
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    Toast.makeText(this, "recent is clicked", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.upload -> {
                    val fragment= UploadFragment.newInstance("","")
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    Toast.makeText(this, "upload is clicked", Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    false
                }
            }
        }


    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
        super.onBackPressed()
    }
}