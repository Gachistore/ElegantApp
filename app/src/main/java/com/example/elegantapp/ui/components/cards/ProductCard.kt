package com.example.elegantapp.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.model.ProductData
import com.example.elegantapp.ui.theme.Black900
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.FilledStarColor
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Neutral01
import com.example.elegantapp.ui.theme.Neutral04
import com.example.elegantapp.ui.theme.Neutral07
import com.example.elegantapp.ui.theme.OutlinedStarColor
import com.example.elegantapp.ui.theme.ProductCardAddToCartButton
import com.example.elegantapp.ui.theme.ProductCardAddToCartTitle
import com.example.elegantapp.ui.theme.ProductCardPreviousPrice
import com.example.elegantapp.ui.theme.ProductCardPrice
import com.example.elegantapp.ui.theme.ProductCardTitle
import com.example.elegantapp.ui.theme.Secondary
import java.text.NumberFormat

@Composable
fun ProductCard(
    data: ProductData,
    isVertical: Boolean = true,
    modifier: Modifier = Modifier
) {
    if(isVertical) {
        Card(
            modifier = modifier
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(308.dp)
                ) {
                    Image(
                        painter = painterResource(id = data.image),
                        contentDescription = stringResource(R.string.product_description, data.title),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Row {
                            Column {
                                if (data.isNew) {
                                    Card(
                                        modifier = Modifier
                                            .size(width = 67.dp, height = 24.dp)
                                            .align(Alignment.CenterHorizontally),
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.new_on_product),
                                            textAlign = TextAlign.Center,
                                            fontFamily = Inter,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onBackground,
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(color = Color.White)
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                }
                                if (data.discount > 0) {
                                    Card(
                                        modifier = Modifier
                                            .size(width = 71.dp, height = 24.dp)
                                            .align(Alignment.CenterHorizontally),
                                        shape = RoundedCornerShape(4.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Secondary
                                        )
                                    ) {
                                        Text(
                                            text = "${
                                                stringResource(
                                                    R.string.discount_on_product,
                                                    data.discount
                                                )
                                            }%",
                                            textAlign = TextAlign.Center,
                                            fontFamily = Inter,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSecondary,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                }
                            }
                            Spacer(Modifier.weight(1f))
                            Card(
                                shape = ShapeDefaults.ExtraLarge,
                                modifier = Modifier.size(32.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                )
                            ) {
                                IconButton(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(color = Color.White)
                                        .align(Alignment.CenterHorizontally),
                                    onClick = { data.copy(isLiked = !data.isLiked) }
                                ) {
                                    Icon(
                                        imageVector = if(!data.isLiked) Icons.Outlined.FavoriteBorder else Icons.Filled.Favorite,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.weight(1f))
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = ProductCardAddToCartButton,
                                contentColor = ProductCardAddToCartTitle
                            ),
                            shape = RoundedCornerShape(8.dp),
                            onClick = {
                                TODO()
                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.add_to_cart),
                                fontFamily = Inter,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Column {
                        Row(
                            modifier = Modifier.padding(top = 5.dp, bottom = 3.dp)
                        ) {
                            repeat(data.rating) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = null,
                                    tint = FilledStarColor,
                                    modifier = Modifier.size(16.dp)

                                )
                            }
                            repeat(5 - data.rating) {
                                Icon(
                                    imageVector = Icons.Outlined.StarOutline,
                                    contentDescription = null,
                                    tint = OutlinedStarColor,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Text(
                            text = data.title,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = ProductCardTitle
                        )
                        Row(
                            modifier = Modifier.padding(top = 3.dp)
                        ) {
                            Text(
                                text = NumberFormat.getCurrencyInstance().format(data.price),
                                fontSize = 14.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.SemiBold,
                                color = ProductCardPrice
                            )
                            Spacer(Modifier.width(12.dp))
                            if (data.previousPrice > data.price) {
                                Text(
                                    text = NumberFormat.getCurrencyInstance()
                                        .format(data.previousPrice),
                                    textDecoration = TextDecoration.LineThrough,
                                    fontSize = 14.sp,
                                    fontFamily = Inter,
                                    fontWeight = FontWeight.Normal,
                                    color = ProductCardPreviousPrice,
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        Card(
            modifier = modifier
        ) {
            Row (
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = data.image),
                        contentDescription = stringResource(R.string.product_description, data.title),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Row {
                            Column {
                                if (data.isNew) {
                                    Card(
                                        modifier = Modifier
                                            .size(width = 67.dp, height = 24.dp)
                                            .align(Alignment.CenterHorizontally),
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.new_on_product),
                                            textAlign = TextAlign.Center,
                                            fontFamily = Inter,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onBackground,
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(color = Color.White)
                                        )
                                    }
                                    Spacer(Modifier.height(8.dp))
                                }
                                if (data.discount > 0) {
                                    Card(
                                        modifier = Modifier
                                            .size(width = 71.dp, height = 24.dp)
                                            .align(Alignment.CenterHorizontally),
                                        shape = RoundedCornerShape(4.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Secondary
                                        )
                                    ) {
                                        Text(
                                            text = "${
                                                stringResource(
                                                    R.string.discount_on_product,
                                                    data.discount
                                                )
                                            }%",
                                            textAlign = TextAlign.Center,
                                            fontFamily = Inter,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSecondary,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row {
                            repeat(data.rating) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = null,
                                    tint = FilledStarColor,
                                    modifier = Modifier.size(16.dp)

                                )
                            }
                            repeat(5 - data.rating) {
                                Icon(
                                    imageVector = Icons.Outlined.StarOutline,
                                    contentDescription = null,
                                    tint = OutlinedStarColor,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Column {
                            Text(
                                text = data.title,
                                fontFamily = Inter,
                                fontWeight = W600,
                                fontSize = 16.sp,
                                lineHeight = 26.sp,
                                color = Neutral07
                            )
                            Spacer(Modifier.height(4.dp))
                            Row {
                                Text(
                                    text = NumberFormat.getCurrencyInstance().format(data.price),
                                    fontSize = 14.sp,
                                    fontFamily = Inter,
                                    fontWeight = FontWeight.SemiBold,
                                    lineHeight = 22.sp,
                                    color = Black900
                                )
                                Spacer(Modifier.width(12.dp))
                                if (data.previousPrice > data.price) {
                                    Text(
                                        text = NumberFormat.getCurrencyInstance()
                                            .format(data.previousPrice),
                                        textDecoration = TextDecoration.LineThrough,
                                        fontSize = 14.sp,
                                        fontFamily = Inter,
                                        fontWeight = FontWeight.Normal,
                                        color = Neutral04,
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = data.description,
                            fontFamily = Inter,
                            fontWeight = W400,
                            fontSize = 12.sp,
                            lineHeight = 22.sp,
                            color = Neutral04,
                            minLines = 4,
                            maxLines = 5
                        )
                        Spacer(Modifier.weight(1f))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Neutral07,
                                    contentColor = Neutral01
                                ),
                                shape = RoundedCornerShape(8.dp),
                                onClick = {
                                    TODO()
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.add_to_cart),
                                    fontFamily = Inter,
                                    fontSize = 16.sp,
                                    fontWeight = W500,
                                )
                            }
                            Row {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = if (!data.isLiked) Icons.Outlined.FavoriteBorder else Icons.Filled.Favorite,
                                        contentDescription = null,
                                        tint = Neutral07,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(Modifier.width(4.dp))
                                    Text(
                                        text = stringResource(R.string.wishlist),
                                        fontFamily = Inter,
                                        fontWeight = W500,
                                        fontSize = 14.sp,
                                        lineHeight = 23.sp,
                                        textAlign = TextAlign.Center,
                                        color = Neutral07
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
private fun ProductCardPreview1() {
    ElegantAppTheme {
        var data = ProductData(
            image = R.drawable.test_sofa,
            isNew = true,
            discount = 50,
            isLiked = false,
            rating = 3,
            title = "Loveseat Sofa",
            description = "Super-soft cushion dffffffffffffffffffcover in off-white with a tactile pattern that enhances the different tones in the pile and base.",
            price = 199,
            previousPrice = 400
        )
        ProductCard(
            data,
            false,
            modifier = Modifier
                .width(540.dp)
                .height(349.dp)
        )
    }
}

@Preview()
@Composable
private fun ProductCardPreview2() {
    ElegantAppTheme {
        var data = ProductData(
            image = R.drawable.test_sofa,
            isNew = false,
            discount = 50,
            isLiked = false,
            rating = 3,
            title = "Loveseat Sofa",
            price = 199,
            previousPrice = 400
        )
        ProductCard(
            data, modifier = Modifier
                .width(231.dp)
                .height(392.dp)
        )
    }
}

@Preview()
@Composable
private fun ProductCardPreview3() {
    ElegantAppTheme {
        var data = ProductData(
            image = R.drawable.test_sofa,
            isNew = false,
            discount = 0,
            isLiked = false,
            rating = 3,
            title = "Loveseat Sofa",
            price = 199,
            previousPrice = 400
        )
        ProductCard(
            data, modifier = Modifier
                .width(262.dp)
                .height(430.dp)
        )
    }
}

@Preview()
@Composable
private fun ProductCardPreview4() {
    ElegantAppTheme {
        var data = ProductData(
            image = R.drawable.test_sofa,
            isNew = true,
            discount = 10,
            isLiked = true,
            rating = 3,
            title = "Loveseat Sofa",
            price = 199,
            previousPrice = 400
        )
        ProductCard(
            data, modifier = Modifier
                .width(262.dp)
                .height(430.dp)
        )
    }
}

@Preview()
@Composable
private fun ProductCardPreview5() {
    ElegantAppTheme {
        var data = ProductData(
            image = R.drawable.test_sofa,
            isNew = true,
            discount = 50,
            isLiked = false,
            rating = 0,
            title = "Loveseat Sofa",
            price = 199,
            previousPrice = 100
        )
        ProductCard(
            data, modifier = Modifier
                .width(262.dp)
                .height(430.dp)
        )
    }
}