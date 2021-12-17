package com.afoxplus.restaurants.delivery.views.adapters.viewholders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.afoxplus.restaurants.entities.Restaurant

internal abstract class RestaurantItemViewHolder(binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root), RestaurantBindViewHolder

internal fun interface RestaurantBindViewHolder {
    fun bind(restaurant: Restaurant)
}