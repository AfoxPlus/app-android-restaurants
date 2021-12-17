package com.afoxplus.restaurants.demo.delivery.views.activities

import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import com.afoxplus.restaurants.demo.databinding.ActivityMainBinding
import com.afoxplus.restaurants.demo.delivery.viewmodels.MainViewModel
import com.afoxplus.uikit.activities.BaseActivity
import com.afoxplus.uikit.adapters.ViewPagerAdapter
import com.afoxplus.uikit.bus.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var restaurantFlow: RestaurantFlow
    private val viewModel: MainViewModel by viewModels()
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
        viewModel.onClickRestaurantHome.observe(this, EventObserver { restaurant ->
            Toast.makeText(this, "${restaurant.name} is Clicked", Toast.LENGTH_SHORT).show()
        })
    }
}