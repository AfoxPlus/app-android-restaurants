package com.afoxplus.restaurants.demo.delivery.views.activities

import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import com.afoxplus.uikit.activities.UIKitBaseActivity
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : UIKitBaseActivity() {
    @Inject
    lateinit var restaurantFlow: RestaurantFlow


    override fun setMainView() {
        setContent {
            UIKitTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    restaurantFlow.RestaurantsComponent(onClickRestaurantHome = {
                        Toast.makeText(
                            this@MainActivity,
                            "Event: ${it.name} is Clicked",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    })
                }
            }
        }
    }

    override fun setUpView() {
        //Do nothing
    }

    override fun observerViewModel() {

    }
}