package com.afoxplus.restaurants.delivery.views.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.afoxplus.restaurants.cross.mappers.toEventModel
import com.afoxplus.restaurants.delivery.events.OnClickRestaurantHome
import com.afoxplus.restaurants.delivery.models.UIState
import com.afoxplus.restaurants.delivery.viewmodels.RestaurantViewModel
import com.afoxplus.restaurants.delivery.views.components.OnClickCardEstablishment
import com.afoxplus.restaurants.delivery.views.components.UIKitCardEstablishment
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.uikit.designsystem.atoms.UIKitText
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.molecules.UIKitLoading
import com.afoxplus.uikit.exceptions.UIException

@Composable
internal fun RestaurantHomeScreen(
    viewModel: RestaurantViewModel = hiltViewModel(),
    onClickRestaurantHome: OnClickRestaurantHome
) {
    val uiState by viewModel.uiStateRestaurant.collectAsState()
    when (uiState) {
        is UIState.OnError -> RestaurantHomeOnError((uiState as UIState.OnError<List<Restaurant>>).uiException)
        is UIState.OnLoading -> RestaurantHomeOnLoading()
        is UIState.OnSuccess -> RestaurantHomeData(
            data = (uiState as UIState.OnSuccess<List<Restaurant>>).data,
            onClickCardEstablishment = { uiModel ->
                viewModel.updateContextRestaurant(uiModel)
                onClickRestaurantHome(uiModel.toEventModel())
            }
        )
    }

    LaunchedEffect(key1 = Unit) { viewModel.fetchRestaurantHome() }
}

@Composable
internal fun RestaurantHomeData(
    modifier: Modifier = Modifier,
    data: List<Restaurant>,
    onClickCardEstablishment: OnClickCardEstablishment
) {
    Column(modifier = modifier.padding(horizontal = UIKitTheme.spacing.spacing16)) {
        data.forEach { restaurant ->
            UIKitCardEstablishment(
                restaurant = restaurant,
                onClickCardEstablishment = onClickCardEstablishment
            )
        }
    }
}

@Composable
internal fun RestaurantHomeOnError(exception: UIException) {
    UIKitText(text = exception.message.toString())
}

@Composable
internal fun RestaurantHomeOnLoading() {
    Box(modifier = Modifier.fillMaxWidth()) {
        UIKitLoading(modifier = Modifier.align(Alignment.Center))
    }

}