package com.afoxplus.restaurants.demo.delivery.views.activities

import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import com.afoxplus.restaurants.delivery.views.screens.EstablishmentScreen
import com.afoxplus.restaurants.demo.delivery.viewmodels.MainViewModel
import com.afoxplus.uikit.activities.UIKitBaseActivity
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : UIKitBaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var restaurantFlow: RestaurantFlow

    @Inject
    lateinit var restaurantBridge: RestaurantBridge

    override fun setMainView() {
        setContent {
            UIKitTheme {
                EstablishmentScreen()
            }
        }
    }

    override fun setUpView() {

    }

    override fun observerViewModel() {

        lifecycleScope.launchWhenCreated {
            viewModel.eventBusListener.collect { event ->
                Toast.makeText(
                    this@MainActivity,
                    "Event: $event is Clicked",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }
}