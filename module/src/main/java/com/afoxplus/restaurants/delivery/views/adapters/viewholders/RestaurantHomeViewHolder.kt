package com.afoxplus.restaurants.delivery.views.adapters.viewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afoxplus.restaurants.databinding.RestaurantHomeItemBinding
import com.afoxplus.restaurants.delivery.views.adapters.listeners.OnClickCardRestaurantListener
import com.afoxplus.restaurants.delivery.views.adapters.listeners.OnClickDeliveryListener
import com.afoxplus.restaurants.entities.Restaurant
import com.bumptech.glide.Glide

internal class RestaurantHomeViewHolder(
    private val context: Context,
    private val binding: RestaurantHomeItemBinding,
    private val listener: OnClickCardRestaurantListener,
    private val onClickDeliveryListener: OnClickDeliveryListener
) :
    RestaurantItemViewHolder(binding) {
    override fun bind(restaurant: Restaurant) {
        binding.btnDelivery.visibility = View.GONE
        binding.restaurant = restaurant
        if (restaurant.ownDelivery) {
            binding.btnDelivery.visibility = View.VISIBLE
        }
        binding.onSelectedRestaurantHome = listener
        binding.onClickDelivery = onClickDeliveryListener
        Glide.with(context).load(restaurant.urlImageLogo)
            .into(binding.restaurantImage)
        binding.executePendingBindings()
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onClickCardRestaurantListener: OnClickCardRestaurantListener,
            onClickDeliveryListener: OnClickDeliveryListener
        ): RestaurantHomeViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RestaurantHomeItemBinding.inflate(layoutInflater, parent, false)
            return RestaurantHomeViewHolder(
                parent.context,
                binding,
                onClickCardRestaurantListener,
                onClickDeliveryListener
            )
        }
    }
}