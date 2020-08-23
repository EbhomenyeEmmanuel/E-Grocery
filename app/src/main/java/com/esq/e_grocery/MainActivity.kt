package com.esq.e_grocery

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.esq.e_grocery.utils.shortToast
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpBottomNav()
        setUpNavView()
    }

    private fun setUpBottomNav() {
        navController = Navigation.findNavController(this, R.id.nav_host_frag)
        bottom_nav.setupWithNavController(navController)
        // NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_cart) {
            //startActivity(Intent(this@MainActivity, MyChartActivity::class.java))
            shortToast("My Chart clicked")
        }
        return true
    }

    private fun setUpNavView() {
        drawerLayout = drawer_layout
        val navView: NavigationView = nav_view
        navView.setNavigationItemSelectedListener(this)
        toolbar.setBackgroundColor(resources.getColor(R.color.nav_view_color))
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.isDrawerIndicatorEnabled = false
        toggle.setHomeAsUpIndicator(R.drawable.nav_icon)
        toggle.setToolbarNavigationClickListener { drawerLayout.openDrawer(Gravity.LEFT); }
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_track_order -> {
                //startActivity(Intent(this@MainActivity, TrackOrderActivity::class.java))
                shortToast("Track Order clicked")
            }
            R.id.nav_order_history -> {
                //startActivity(Intent(this@MainActivity, OrderHistoryActivity::class.java))
                shortToast("Order History clicked")
            }
            R.id.nav_help -> {
                shortToast("Help clicked")
            }
            R.id.nav_settings -> {
                shortToast("Settings clicked")
            }
            R.id.nav_logout -> {
                shortToast("Log out clicked")
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
