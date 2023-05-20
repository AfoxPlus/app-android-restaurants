package com.afoxplus.restaurants.delivery.flow

import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.spy
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class RestaurantFlowActionTest {

    @Test
    fun `Given a flow When implemented flow Then executed action`() {
        val sutRestaurantFlowAction: RestaurantFlowAction = spy()

        val returnData = sutRestaurantFlowAction.getRestaurantHomeFragment()

        assertNotNull(sutRestaurantFlowAction)
        assertNotNull(returnData)
        verify(sutRestaurantFlowAction, times(numInvocations = 1)).getRestaurantHomeFragment()
    }
}