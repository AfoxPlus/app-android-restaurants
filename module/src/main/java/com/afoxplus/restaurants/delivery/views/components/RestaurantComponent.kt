package com.afoxplus.restaurants.delivery.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.uikit.designsystem.atoms.UIKitIcon
import com.afoxplus.uikit.designsystem.atoms.UIKitText
import com.afoxplus.uikit.designsystem.extensions.getUIKitIcon
import com.afoxplus.uikit.designsystem.foundations.UIKitColorTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTypographyTheme

internal fun interface OnClickCardEstablishment {
    operator fun invoke(restaurant: Restaurant)
}

@Composable
internal fun UIKitCardEstablishment(
    restaurant: Restaurant,
    onClickCardEstablishment: OnClickCardEstablishment
) {
    Card(
        modifier = Modifier.clickable { onClickCardEstablishment(restaurant) },
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = UIKitTheme.shapes.smallMedium,
        colors = CardDefaults.cardColors(containerColor = UIKitColorTheme.light01)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                model = restaurant.urlImageBanner,
                contentDescription = restaurant.name,
                contentScale = ContentScale.FillBounds,
            )
            Row(
                modifier = Modifier.padding(
                    horizontal = UIKitTheme.spacing.spacing08,
                    vertical = UIKitTheme.spacing.spacing12
                ),
                horizontalArrangement = Arrangement.spacedBy(UIKitTheme.spacing.spacing08)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(UIKitTheme.spacing.spacing60)
                        .shadow(
                            elevation = UIKitTheme.spacing.spacing02,
                            shape = UIKitTheme.shapes.small,
                            clip = true
                        ),
                    contentScale = ContentScale.FillBounds,
                    model = restaurant.urlImageLogo,
                    contentDescription = restaurant.name
                )
                EstablishmentInformation(restaurant)
            }
        }
    }
}

@Composable
internal fun EstablishmentInformation(restaurant: Restaurant) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(UIKitTheme.spacing.spacing04)
    ) {
        UIKitText(
            modifier = Modifier.fillMaxWidth(),
            text = restaurant.name, style = UIKitTypographyTheme.header02Bold
        )
        UIKitText(
            modifier = Modifier.fillMaxWidth(),
            text = restaurant.category,
            style = UIKitTypographyTheme.paragraph01SemiBold
        )
        UIKitText(
            modifier = Modifier.fillMaxWidth(),
            text = restaurant.summary,
            style = UIKitTypographyTheme.paragraph02,
            color = UIKitColorTheme.gray500
        )
        restaurant.information?.forEach { item ->
            IconWithDescriptionHorizontal(
                iconToken = item.code,
                description = item.name
            )
        }
    }
}

@Composable
internal fun IconWithDescriptionHorizontal(iconToken: String, description: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(UIKitTheme.spacing.spacing04)) {
        getUIKitIcon(iconToken)?.let {
            UIKitIcon(
                modifier = Modifier.size(UIKitTheme.spacing.spacing14),
                icon = it,
                contentDescription = description
            )
        }
        UIKitText(
            modifier = Modifier.fillMaxWidth(),
            text = description,
            style = UIKitTypographyTheme.paragraph02,
            color = UIKitColorTheme.gray700
        )
    }
}