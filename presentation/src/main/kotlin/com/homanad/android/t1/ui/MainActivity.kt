package com.homanad.android.t1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.homanad.android.t1.R
import com.homanad.android.t1.common.Animator
import com.homanad.android.t1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

//    override val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        observeData()
        updateUI()
    }

    fun observeData() {

    }

    fun updateUI() {
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener(this)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,
//                R.id.accountFragment,
//                R.id.statisticFragment,
//                R.id.settingFragment
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.ic_home,
                R.drawable.avd_home,
                R.id.homeFragment
            ),
            CbnMenuItem(
                R.drawable.ic_account,
                R.drawable.avd_account,
                R.id.calendarFragment
            ),
            CbnMenuItem(
                R.drawable.ic_statistics,
                R.drawable.avd_statistics,
                R.id.statisticFragment
            ),
            CbnMenuItem(
                R.drawable.ic_settings,
                R.drawable.avd_settings,
                R.id.settingFragment
            )
        )
        binding.navView.setMenuItems(menuItems, 0)
        binding.navView.setupWithNavController(navController)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.homeFragment, R.id.calendarFragment -> {
                Animator.showBottomBar(binding.navView, onAnimationEnd = {})
            }
            else -> {
                Animator.hideBottomBar(binding.navView, onAnimationEnd = {})
            }
        }
    }
}