package com.afoxplus.restaurants.usecases

import com.afoxplus.home.utils.TestCoroutineRule
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
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

    /*private val sutFetchRestaurantHomeUseCase: FetchRestaurantHomeUseCase by lazy {
        FetchRestaurantHomeUseCase(
            mockRestaurantRepository
        )
    }*/

    private lateinit var sutUseCase: FetchRestaurantHomeUseCase

    @Before
    fun setup() {
        sutUseCase = FetchRestaurantHomeUseCase(mockRestaurantRepository)
    }

    @Test
    fun executeInvoke() {
        ruleTestCoroutine.runBlockingTest {
            //Given
            val mockList: List<Restaurant> = mock()
            whenever(mockRestaurantRepository.fetchHome()).doReturn(mockList)
            //When
            sutUseCase.invoke()
            //Then
            assertNotNull(sutUseCase)
            assertNotNull(mockRestaurantRepository)
            verify(mockRestaurantRepository, times(numInvocations = 1)).fetchHome()
            assertEquals(mockList, sutUseCase.invoke())
        }
    }

}