package com.example.elegantapp.ui.components.cards

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.ui.screens.LinkButtonWithArrow
import com.example.elegantapp.ui.theme.BlackOnCards
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.HomePageProductCategoryColor
import com.example.elegantapp.ui.theme.LinkButtonWithArrowColor
import com.example.elegantapp.ui.theme.Poppins

@Composable
fun HomePageProductCategoryCard(
    @StringRes text: Int,
    @DrawableRes image: Int,
    isBigImage: Boolean,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = HomePageProductCategoryColor
        ),
        shape = RoundedCornerShape(0.dp),
        modifier = modifier
    ) {
        if (isBigImage) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.home_page_product_category_card_padding))
            ) {
                Text(
                    text = stringResource(id = text),
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    lineHeight = 34.sp,
                    color = BlackOnCards,
                    textAlign = TextAlign.Start
                )
                Spacer(Modifier.height(6.dp))
                LinkButtonWithArrow(
                    text = R.string.shop_now,
                    fontSize = 13,
                    color = LinkButtonWithArrowColor
                )

            }
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(text),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(279.dp)
            )
        } else {
            Row {
                Column(
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.home_page_product_category_card_padding),
                        top = dimensionResource(R.dimen.home_page_product_category_card_padding),
                        bottom = dimensionResource(R.dimen.home_page_product_category_card_padding),
                    )
                ) {
                    Spacer(Modifier.height(50.dp))
                    Column {
                        Text(
                            text = stringResource(text),
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 28.sp,
                            lineHeight = 34.sp,
                            color = BlackOnCards,
                            textAlign = TextAlign.Start
                        )
                        Spacer(Modifier.height(6.dp))
                        LinkButtonWithArrow(
                            text = R.string.shop_now,
                            fontSize = 13,
                            color = LinkButtonWithArrowColor
                        )
                    }
                }
                Image(
                    painter = painterResource(image),
                    contentDescription = stringResource(text),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(end = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomePageProductCategoryCardPreview() {
    ElegantAppTheme {
        HomePageProductCategoryCard(
            text = R.string.living_room,
            image = R.drawable.living_room_chair,
            isBigImage = false
        )
    }
}