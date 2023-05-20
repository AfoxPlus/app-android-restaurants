package com.afoxplus.restaurants.delivery.views.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.afoxplus.restaurants.entities.Restaurant

internal class RestaurantDiffUtilCallback : DiffUtil.ItemCallback<Restaurant>() {
    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
        oldItem.code == newItem.code

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
        oldItem.code == newItem.code
                && oldItem.name == newItem.name
                && oldItem.description == newItem.description
}