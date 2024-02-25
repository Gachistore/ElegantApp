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
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.material3.MaterialTheme
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
import com.example.elegantapp.ui.theme.Secondary
import java.text.NumberFormat

@Composable
fun ProductCardHorizontal(
    data: ProductData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
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
                    .weight(3f)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
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
                            fontWeight = FontWeight.W600,
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
                    Spacer(Modifier.height(14.dp))
                    Text(
                        text = data.description,
                        fontFamily = Inter,
                        fontWeight = FontWeight.W400,
                        fontSize = 10.sp,
                        lineHeight = 22.sp,
                        color = Neutral04,
                        minLines = 2,
                        maxLines = 2
                    )
                    Spacer(Modifier.weight(1f))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(36.dp),
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
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                            )
                        }
                        Row {
                            TextButton(
                                onClick = { /*TODO*/ },
                                contentPadding = ButtonDefaults.TextButtonWithIconContentPadding
                            ) {
                                Icon(
                                    imageVector = if (!data.isLiked) Icons.Outlined.FavoriteBorder else Icons.Filled.Favorite,
                                    contentDescription = null,
                                    tint = Neutral07,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = stringResource(R.string.wishlist),
                                    fontFamily = Inter,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    lineHeight = 18.sp,
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
        ProductCardHorizontal(
            data,
            modifier = Modifier
                .width(313.dp)
                .height(250.dp)
        )
    }
}