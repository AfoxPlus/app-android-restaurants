package com.afoxplus.restaurants.delivery.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.afoxplus.restaurants.delivery.viewmodels.EstablishmentViewModel
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.common.UIState
import com.afoxplus.uikit.designsystem.atoms.UIKitText
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTypographyTheme
import com.afoxplus.uikit.designsystem.molecules.UIKitLoading
import com.afoxplus.uikit.designsystem.organisms.UIKitCardEstablishment
import com.afoxplus.uikit.objects.vendor.Establishment

@Composable
fun EstablishmentScreen(modifier: Modifier = Modifier) {
    EstablishmentScreen(modifier, viewModel = hiltViewModel())
}

@Composable
private fun EstablishmentScreen(
    modifier: Modifier = Modifier,
    viewModel: EstablishmentViewModel
) {
    val establishmentsState by viewModel.establishmentState.collectAsState()
    when (establishmentsState) {
        is UIState.OnError -> HandleOnError(
            modifier = modifier,
            message = (establishmentsState as UIState.OnError<List<Restaurant>>).uiException.message.orEmpty()
        )

        is UIState.OnLoading -> HandleOnLoading(modifier = modifier)
        is UIState.OnSuccess -> HandleOnSuccess(
            modifier = modifier,
            establishments = (establishmentsState as UIState.OnSuccess<List<Restaurant>>).data,
            onClick = {
                viewModel.onClickCardRestaurant(it)
            })
    }

}

@Composable
private fun HandleOnError(modifier: Modifier = Modifier, message: String) {
    Box(modifier = modifier.fillMaxSize()) {
        UIKitText(
            modifier = Modifier.padding(UIKitTheme.spacing.spacing16),
            text = message,
            style = UIKitTypographyTheme.header02SemiBold
        )
    }
}

@Composable
private fun HandleOnLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        UIKitLoading(
            modifier = Modifier.align(Alignment.Center),
            circleSize = UIKitTheme.spacing.spacing12
        )
    }
}

@Composable
private fun HandleOnSuccess(
    modifier: Modifier = Modifier,
    establishments: List<Restaurant>,
    onClick: (Restaurant) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = UIKitTheme.spacing.spacing16,
            vertical = UIKitTheme.spacing.spacing12
        ),
        verticalArrangement = Arrangement.spacedBy(UIKitTheme.spacing.spacing12),
        state = listState
    ) {
        itemsIndexed(items = establishments, key = { _, item -> item.code }) { _, establishment ->
            UIKitCardEstablishment(
                establishment = Establishment(
                    imageLandscape = establishment.urlImageBanner,
                    imagePortrait = establishment.urlImageLogo,
                    name = establishment.name,
                    description = establishment.primaryType,
                    hasSubscription = establishment.hasSubscription,
                    isOpen = establishment.isOpen,
                    rating = establishment.rating,
                    addressDescription = establishment.address,
                    phoneDescription = establishment.phone
                ),
                context = LocalContext.current
            ) {
                onClick(establishment)
            }
        }
    }
}