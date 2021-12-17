package com.afoxplus.restaurants.delivery.views.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.afoxplus.restaurants.databinding.RestaurantHomeFragmentBinding
import com.afoxplus.restaurants.delivery.viewmodels.RestaurantViewModel
import com.afoxplus.restaurants.delivery.views.adapters.RestaurantAdapter
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.fragments.BaseFragment

internal class RestaurantHomeFragment : BaseFragment() {
    private lateinit var binding: RestaurantHomeFragmentBinding
    private val viewModel: RestaurantViewModel by activityViewModels()
    private val adapter: RestaurantAdapter by lazy { RestaurantAdapter() }

    override fun getMainView(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = RestaurantHomeFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun setUpView() {
        binding.adapter = adapter
        adapter.setOnClickCardRestaurantListener(::onClickCardRestaurant)
        viewModel.fetchRestaurantHome()
    }

    override fun observerViewModel() {
        viewModel.restaurantsHome.observe(viewLifecycleOwner) { restaurants ->
            adapter.submitList(restaurants)
        }
    }

    private fun onClickCardRestaurant(restaurant: Restaurant) {
        viewModel.onClickCardRestaurant(restaurant)
    }
}