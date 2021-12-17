package com.afoxplus.restaurants.delivery.views.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.afoxplus.restaurants.delivery.views.adapters.diffutils.RestaurantDiffUtilCallback
import com.afoxplus.restaurants.delivery.views.adapters.listeners.OnClickCardRestaurantListener
import com.afoxplus.restaurants.delivery.views.adapters.viewholders.RestaurantHomeViewHolder
import com.afoxplus.restaurants.delivery.views.adapters.viewholders.RestaurantItemViewHolder
import com.afoxplus.restaurants.entities.Restaurant

internal class RestaurantAdapter :
    ListAdapter<Restaurant, RestaurantItemViewHolder>(RestaurantDiffUtilCallback()) {

    private var onClickCardRestaurantListener: OnClickCardRestaurantListener =
        OnClickCardRestaurantListener {}

    fun setOnClickCardRestaurantListener(listener: OnClickCardRestaurantListener) {
        onClickCardRestaurantListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantItemViewHolder {
        return RestaurantHomeViewHolder.from(parent, onClickCardRestaurantListener)
    }

    override fun onBindViewHolder(holder: RestaurantItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun getItemViewType(position: Int): Int = getItem(position).getViewType()
}