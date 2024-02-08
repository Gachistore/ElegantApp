package com.example.elegantapp.ui.screens

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.ui.components.Footer
import com.example.elegantapp.ui.components.cards.HomePageProductCategoryCard
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Popins

@Composable
fun HomePageScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        Introduction(
            image = R.drawable.introduction_sofa,
            modifier = Modifier
                .padding(
                    start = dimensionResource(R.dimen.home_page_start_padding),
                    end = dimensionResource(R.dimen.home_page_end_padding),
                )
                .fillMaxWidth()
                .wrapContentHeight()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.introduction_bottom_padding)))
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(
                    start = dimensionResource(R.dimen.home_page_start_padding),
                    end = dimensionResource(R.dimen.home_page_end_padding)
                )
                .fillMaxWidth()
        ) {
            HomePageProductCategoryCard(
                text = R.string.living_room,
                image = R.drawable.living_room_chair,
                isBigImage = true
            )
            HomePageProductCategoryCard(
                text = R.string.bedroom,
                image = R.drawable.bedroom_nightstand,
                isBigImage = false
            )
            HomePageProductCategoryCard(
                text = R.string.kitchen,
                image = R.drawable.kitchen_toster,
                isBigImage = false
            )
        }
        Spacer(Modifier.height(32.dp))


        Footer()
    }
}

@Composable
private fun Introduction(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(R.string.introduction_sofa_content_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(304.dp)
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF141718))) {
                    append("Simply Unique")
                }
                withStyle(style = SpanStyle(color = Color(0xFF6C7275))) {
                    append("/")
                }
                withStyle(style = SpanStyle(color = Color(0xFF141718))) {
                    append("Simply Better")
                }
                withStyle(style = SpanStyle(color = Color(0xFF6C7275))) {
                    append(".")
                }
            },
            fontFamily = Popins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 37.sp,
            lineHeight = 41.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF343839),
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(stringResource(id = R.string.three_legant))
                }
                withStyle(style = SpanStyle(color = Color(0xFF6C7275))) {
                    append(" is a gift & decorations store based in HCMC, Vietnam. Est since 2019.")
                }
            },
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun LinkButtonWithArrow(
    onClick: () -> Unit = {},
    @StringRes text: Int,
    fontSize: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable { onClick }
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(text),
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = fontSize.sp,
                    color = color
                )
                Spacer(Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = "Go to the ",
                    tint = color,
                    modifier = Modifier.size(fontSize.dp)
                )
            }
            Divider(
                thickness = 1.dp,
                color = color,
                modifier = Modifier.width(83.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePageScreenPreview() {
    ElegantAppTheme {
        HomePageScreen()
    }
}

