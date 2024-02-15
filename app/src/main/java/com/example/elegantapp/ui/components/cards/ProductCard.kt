package com.example.elegantapp.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.model.ProductData
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.FilledStarColor
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.OutlinedStarColor
import com.example.elegantapp.ui.theme.ProductCardAddToCartButton
import com.example.elegantapp.ui.theme.ProductCardAddToCartTitle
import com.example.elegantapp.ui.theme.ProductCardPreviousPrice
import com.example.elegantapp.ui.theme.ProductCardPrice
import com.example.elegantapp.ui.theme.ProductCardTitle
import com.example.elegantapp.ui.theme.Secondary
import java.text.NumberFormat

@Composable
fun ProductCard(data: ProductData, modifier: Modifier = Modifier) {
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
                                if (!data.isLiked) {
                                    Icon(
                                        imageVector = Icons.Outlined.FavoriteBorder,
                                        contentDescription = null
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = null
                                    )
                                }
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