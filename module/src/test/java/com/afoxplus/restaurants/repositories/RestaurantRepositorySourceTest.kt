package com.afoxplus.restaurants.repositories

import com.afoxplus.home.utils.TestCoroutineRule
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
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

    private lateinit var sutRepositorySource: RestaurantRepositorySource

    @Before
    fun setup() {
        sutRepositorySource = RestaurantRepositorySource(mockDataSource)
    }

    @Test
    fun invokeFetchHome() {
        ruleTestCoroutine.runBlockingTest {
            //Given
            val mockList: List<Restaurant> = mock()
            whenever(mockDataSource.fetchHome()).doReturn(mockList)
            //When
            sutRepositorySource.fetchHome()
            //Then
            assertNotNull(mockDataSource)
            assertNotNull(sutRepositorySource)
            verify(mockDataSource, times(numInvocations = 1)).fetchHome()
            assertEquals(mockList, sutRepositorySource.fetchHome())
        }
    }

}