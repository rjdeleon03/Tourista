package com.pabsdl.tourista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController
//    private lateinit var mAppBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavController = findNavController(R.id.mainActivityFragment)
        mainActivityNavigationView.setupWithNavController(mNavController)

//        setupAppBar()
    }

    /*
    override fun onSupportNavigateUp(): Boolean {
        /* Override the default navigate up action */
        return navigateUp(mNavController, mAppBarConfig)
    }

    override fun onBackPressed() {
        /* Support closing of drawer when back button is pressed */
        if (mainActivityDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainActivityDrawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }

    private fun setupAppBar() {

        /* Set the action bar */
        setSupportActionBar(mainActivityToolbar)

        /* Create app bar configuration */
        mAppBarConfig = AppBarConfiguration(setOf(
            R.id.currencyConverterFragment,
            R.id.visaInformationFragment),
            mainActivityDrawerLayout)

        /* Setup app bar config with the nav controller */
        setupActionBarWithNavController(mNavController, mAppBarConfig)

        /* Setup activity with the nav controller */
        mainActivityNavigationView.setupWithNavController(mNavController)

        /* Setup navigation drawer listener */
        mainActivityNavigationView.menu.getItem(0).isChecked = true
        mainActivityNavigationView.setNavigationItemSelectedListener { menuItem ->
            if (!menuItem.isChecked) {
                menuItem.isChecked = true
                when (menuItem.itemId) {
                    R.id.menuCurrencyConversion -> {
                        mNavController.navigate(R.id.action_to_currencyConverterFragment)
                    }
                    R.id.menuVisaInformation -> {
                        mNavController.navigate(R.id.action_to_visaInformationFragment)
                    }
                }
            }

            mainActivityDrawerLayout.closeDrawers()
            true
        }
    }
    */
}
