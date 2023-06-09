package com.afoxplus.restaurants.demo.delivery.views.activities

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import com.afoxplus.restaurants.demo.databinding.ActivityMainBinding
import com.afoxplus.restaurants.demo.delivery.viewmodels.MainViewModel
import com.afoxplus.uikit.activities.UIKitBaseActivity
import com.afoxplus.uikit.adapters.UIKitViewPagerAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : UIKitBaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var restaurantFlow: RestaurantFlow

    @Inject
    lateinit var restaurantBridge: RestaurantBridge

    private lateinit var viewPagerAdapter: UIKitViewPagerAdapter

    override fun setMainView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setUpView() {
        viewPagerAdapter = UIKitViewPagerAdapter(
            supportFragmentManager,
            lifecycle,
            listOf(restaurantFlow.getRestaurantHomeFragment())
        )
        binding.viewPagerMarket.adapter = viewPagerAdapter
        binding.viewPagerMarket.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun observerViewModel() {
        viewModel.onClickRestaurantHome.observe(this) { restaurant ->
            Toast.makeText(this, "Toast 1: ${restaurant.name} is Clicked", Toast.LENGTH_LONG)
                .show()
        }

        restaurantBridge.fetchRestaurant().observe(this) { restaurant ->
            Snackbar.make(binding.root, restaurant.name, Snackbar.LENGTH_LONG).show()
        }

        lifecycleScope.launchWhenCreated {
            viewModel.onClickDeliveryEvent.collectLatest { event ->
                Toast.makeText(
                    this@MainActivity,
                    "Delivery: ${event.restaurant.name} is Clicked",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }
}