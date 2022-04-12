package com.afoxplus.restaurants.demo.delivery.views.activities

import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import com.afoxplus.restaurants.demo.databinding.ActivityMainBinding
import com.afoxplus.restaurants.demo.delivery.viewmodels.MainViewModel
import com.afoxplus.uikit.activities.BaseActivity
import com.afoxplus.uikit.adapters.ViewPagerAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var restaurantFlow: RestaurantFlow

    @Inject
    lateinit var restaurantBridge: RestaurantBridge

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun setMainView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setUpView() {
        viewPagerAdapter = ViewPagerAdapter(
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
    }
}