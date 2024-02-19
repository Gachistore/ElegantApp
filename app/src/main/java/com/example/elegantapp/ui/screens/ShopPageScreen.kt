package com.example.elegantapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.model.ProductData
import com.example.elegantapp.ui.components.Footer
import com.example.elegantapp.ui.theme.Black900
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Neutral03
import com.example.elegantapp.ui.theme.Neutral07
import com.example.elegantapp.ui.theme.Poppins

@Composable
fun ShopPageScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        TitleImage(
            image = R.drawable.shop_page_sofa,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
        )



        JoinOurNes(
            modifier = Modifier
                .fillMaxWidth()
        )
        Footer()
    }
}

@Composable
fun TitleImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.height(308.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "ShopPage image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.shop_page),
                fontFamily = Poppins,
                fontWeight = FontWeight.W500,
                fontSize = 40.sp,
                lineHeight = 43.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Let’s design the place you always imagined.",
                fontFamily = Inter,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 25.sp,
                textAlign = TextAlign.Center,
                color = Black900
            )
        }
    }
}

@Composable
private fun ProductsList(
    productsList: List<ProductData>?,
    modifier: Modifier = Modifier
) {
    var isEnabled by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 32.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .topBorder(1.dp, Neutral03)
                    .bottomBorder(1.dp, Neutral03)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Tune,
                    contentDescription = "Filter",
                    tint = Neutral07,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.filter),
                    fontFamily = Inter,
                    fontWeight = W600,
                    fontSize = 16.sp,
                    lineHeight = 25.sp,
                    color = Black900
                )
                Spacer(Modifier.weight(1f))
                Row(
                    modifier = Modifier.border(1.dp, Neutral03)
                ) {
                    IconButton(onClick = { isEnabled = true }) {
                        
                    }
                    IconButton(onClick = { isEnabled = false }) {

                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ShopPageScreenPreview() {
    ElegantAppTheme {
        ShopPageScreen()
    }
}