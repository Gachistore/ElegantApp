package com.example.elegantapp.ui.components

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
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.model.ProductCardData
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.FilledStarColor
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.OutlinedStarColor
import com.example.elegantapp.ui.theme.Secondary
import java.text.NumberFormat

@Composable
fun ProductCard(data: ProductCardData, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Row {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(349.dp)
            ) {
                Image(
                    painter = painterResource(id = data.image),
                    contentDescription = stringResource(R.string.product_description, data.title),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column (
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                ) {
                    if(data.isNew) {
                        Card (
                            modifier = Modifier
                                .size(width = 67.dp, height = 24.dp)
                                .background(color = Color.White)
                                .align(Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(4.dp)
                        ){
                            Text(
                                text = stringResource(id = R.string.new_on_product),
                                textAlign = TextAlign.Center,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                    }
                    if(data.discount > 0) {
                        Card (
                            modifier = Modifier
                                .size(width = 71.dp, height = 24.dp)
                                .background(color = MaterialTheme.colorScheme.secondary)
                                .align(Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(4.dp),
                        ){
                            Text(
                                text = stringResource(R.string.discount_on_product, data.discount),
                                textAlign = TextAlign.Center,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                }
            }
            Row {
                Column {
                    Row {
                        repeat(data.rating) {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = FilledStarColor,
                                modifier = Modifier.size(16.dp).padding(1.dp)
                            )
                        }
                        repeat(5 - data.rating) {
                            Icon (
                                imageVector = Icons.Outlined.Star,
                                contentDescription = null,
                                tint = OutlinedStarColor,
                                modifier = Modifier.size(16.dp).padding(1.dp)
                            )
                        }
                    }
                    Text(
                        text = data.title,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Row {
                        Text(
                            text = NumberFormat.getCurrencyInstance().format(data.price),
                            textDecoration = TextDecoration.LineThrough,
                            fontSize = 14.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = NumberFormat.getCurrencyInstance().format(data.previousPrice),
                            textDecoration = TextDecoration.LineThrough,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 14.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun ProductCardPreview() {
    ElegantAppTheme {
        val data = ProductCardData(
            image = R.drawable.test_sofa,
            isNew = true,
            discount = 20,
            isLiked = true,
            rating = 4,
            title = "The best sofa in the world",
            price = 120,
            previousPrice = 240
        )
        ProductCard(data, modifier = Modifier
            .width(262.dp)
            .height(433.dp)
        )
    }
}