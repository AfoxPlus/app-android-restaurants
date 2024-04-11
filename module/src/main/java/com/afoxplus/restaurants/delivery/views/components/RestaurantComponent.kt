package com.afoxplus.restaurants.delivery.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.afoxplus.restaurants.R
import com.afoxplus.restaurants.delivery.models.RestaurantUIModel
import com.afoxplus.uikit.designsystem.atoms.UIKitText
import com.afoxplus.uikit.designsystem.foundations.UIKitColorTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTypographyTheme

@Composable
internal fun UIKitCardEstablishment(restaurant: RestaurantUIModel) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = UIKitTheme.spacing.spacing02
        ),
        shape = UIKitTheme.shapes.smallMedium,
        colors = CardDefaults.cardColors(containerColor = UIKitColorTheme.light01)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                model = restaurant.urlBanner,
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
                    model = restaurant.urlLogo,
                    contentDescription = restaurant.name
                )
                EstablishmentInformation(restaurant)
            }
        }
    }
}

@Composable
internal fun EstablishmentInformation(restaurant: RestaurantUIModel) {
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
        restaurant.data.forEach { item ->
            IconWithDescriptionHorizontal(
                painterResource(id = item.key),
                description = item.value
            )
        }
    }
}

@Composable
internal fun IconWithDescriptionHorizontal(painter: Painter, description: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(UIKitTheme.spacing.spacing04)) {
        Icon(
            modifier = Modifier.size(UIKitTheme.spacing.spacing14),
            painter = painter,
            contentDescription = description,
            tint = UIKitColorTheme.gray700
        )
        UIKitText(
            modifier = Modifier.fillMaxWidth(),
            text = description,
            style = UIKitTypographyTheme.paragraph02,
            color = UIKitColorTheme.gray700
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowComponent() = UIKitTheme {
    val restaurant =
        RestaurantUIModel(
            urlBanner = "https://t3.ftcdn.net/jpg/03/35/51/06/360_F_335510693_HY7mLg3ARdLccKoXk3m66NLDpJRJh51p.jpg",
            urlLogo = "",
            name = "Kitchen",
            category = "Cafe & Resto",
            summary = "Desayunos, almuerzos, cenas, platos a la carta y bebidas",
            data = mapOf(
                R.drawable.ic_restaurant_location to "Avenida arenales 1241",
                R.drawable.ic_restaurant_whatsapp to "966885488"
            )
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(UIKitTheme.spacing.spacing16),
        verticalArrangement = Arrangement.spacedBy(UIKitTheme.spacing.spacing08)
    ) {
        UIKitCardEstablishment(restaurant)
        UIKitCardEstablishment(restaurant)
    }

}