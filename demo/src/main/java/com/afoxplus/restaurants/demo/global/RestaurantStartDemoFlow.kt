package com.afoxplus.restaurants.demo.global

import android.content.Intent
import com.afoxplus.module.delivery.flow.StartDemoFlow
import com.afoxplus.restaurants.demo.delivery.views.activities.MainActivity
import com.afoxplus.uikit.activities.UIKitBaseActivity
import javax.inject.Inject

class RestaurantStartDemoFlow @Inject constructor() : StartDemoFlow {
    override fun start(activity: UIKitBaseActivity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }
}