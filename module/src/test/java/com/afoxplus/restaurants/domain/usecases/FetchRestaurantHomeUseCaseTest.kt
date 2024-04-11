package com.afoxplus.restaurants.domain.usecases

import com.afoxplus.restaurants.domain.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.repositories.RestaurantRepository
import com.afoxplus.restaurants.utils.TestCoroutineRule
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
class FetchRestaurantHomeUseCaseTest {

    @get:Rule
    val ruleTestCoroutine = TestCoroutineRule()

    private val mockRestaurantRepository: RestaurantRepository = mock()

    private lateinit var sutUseCase: FetchRestaurantHomeUseCase

    @Before
    fun setup() {
        sutUseCase = FetchRestaurantHomeUseCase(mockRestaurantRepository)
    }

    @Test
    fun `Given a restaurant list When execute invoke Then validate flow it's ok`() {
        ruleTestCoroutine.runBlockingTest {
            val mockList: List<Restaurant> = mock()
            whenever(mockRestaurantRepository.fetchHome()).doReturn(mockList)

            sutUseCase.invoke()

            assertNotNull(sutUseCase)
            assertNotNull(mockRestaurantRepository)
            verify(mockRestaurantRepository, times(numInvocations = 1)).fetchHome()
            assertEquals(mockList, sutUseCase.invoke())
        }
    }

}