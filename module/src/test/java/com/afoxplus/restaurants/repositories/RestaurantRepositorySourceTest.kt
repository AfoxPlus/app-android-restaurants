package com.afoxplus.restaurants.repositories

import com.afoxplus.restaurants.services.repositories.RestaurantRepositorySource
import com.afoxplus.restaurants.utils.TestCoroutineRule
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.services.sources.local.cache.RestaurantLocalDataSource
import com.afoxplus.restaurants.services.sources.network.RestaurantNetworkDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class RestaurantRepositorySourceTest {

    @get:Rule
    val ruleTestCoroutine = TestCoroutineRule()

    private val mockDataSource: RestaurantNetworkDataSource = mock()
    private val mockLocalDataSource: RestaurantLocalDataSource = mock()

    private lateinit var sutRepositorySource: RestaurantRepositorySource

    @Before
    fun setup() {
        sutRepositorySource = RestaurantRepositorySource(mockDataSource, mockLocalDataSource)
    }

    @Test
    fun `Given a restaurant list When execute fetchHome Then validate flow it's ok`() {
        ruleTestCoroutine.runBlockingTest {
            val mockList: List<Restaurant> = mock()
            whenever(mockDataSource.fetchHome()).doReturn(mockList)

            sutRepositorySource.fetchHome()

            assertNotNull(mockDataSource)
            assertNotNull(sutRepositorySource)
            verify(mockDataSource, times(numInvocations = 1)).fetchHome()
            assertEquals(mockList, sutRepositorySource.fetchHome())
        }
    }

}