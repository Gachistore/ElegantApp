package com.example.elegantapp.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.ui.theme.DrawerCloseButtonColor
import com.example.elegantapp.ui.theme.DrawerSearchIconColor
import com.example.elegantapp.ui.theme.DrawerSearchTextFieldColor
import com.example.elegantapp.ui.theme.DrawerTitleBottomBorderColor
import com.example.elegantapp.ui.theme.DrawerTitlesBasketColor
import com.example.elegantapp.ui.theme.DrawerTitlesBasketIconsColor
import com.example.elegantapp.ui.theme.DrawerTitlesColor
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Poppins
import androidx.annotation.IntRange
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import com.example.elegantapp.ui.theme.ProductCardAddToCartButton

@Composable
fun FlyMenu(
    onClose: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var searchText by rememberSaveable {
        mutableStateOf("")
    }

    Surface(
        color = Color.White,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 10.dp,
                    bottom = 24.dp
                )
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.three_legant),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 23.sp,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )
                    IconButton(onClick = onClose) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null,
                            tint = DrawerCloseButtonColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    label = {
                        Text(
                            text = stringResource(R.string.search),
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            lineHeight = 22.sp,
                            color = DrawerSearchTextFieldColor
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = null,
                            tint = DrawerSearchIconColor
                        )
                    },
                    prefix = {
                        Spacer(Modifier.width(10.dp))
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Column {
                    FlyMenuTitle(
                        titleRes = R.string.home,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* TODO */ }
                    )
                    FlyMenuTitle(
                        titleRes = R.string.shop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* TODO */ }
                    )
                    FlyMenuTitle(
                        titleRes = R.string.product,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* TODO */ }
                    )
                    FlyMenuTitle(
                        titleRes = R.string.contact_us,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* TODO */ }

                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(19.33.dp)
            ) {
                Column {
                    FlyMenuBasket(
                        titleRes = R.string.cart,
                        icon = Icons.Outlined.ShoppingBag,
                        addedCount = 2,
                        modifier = Modifier.fillMaxWidth()
                    )
                    FlyMenuBasket(
                        titleRes = R.string.wishlist,
                        icon = Icons.Outlined.FavoriteBorder,
                        addedCount = 3,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ProductCardAddToCartButton,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        TODO()
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        fontFamily = Inter,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_instagram_outlined),
                            contentDescription = "Follow us in instagram",
                            tint = DrawerSearchIconColor
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_facebook_outlined),
                            contentDescription = "Follow us in facebook",
                            tint = DrawerSearchIconColor
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_youtube_outlined),
                            contentDescription = "Follow us in youtube",
                            tint = DrawerSearchIconColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FlyMenuTitle(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.bottomBorder(strokeWidth = 1.dp, color = DrawerTitleBottomBorderColor)
    ) {
        Text(
            text = stringResource(titleRes),
            fontFamily = Inter,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = DrawerTitlesColor,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

@Composable
private fun FlyMenuBasket(
    @StringRes titleRes: Int,
    icon: ImageVector,
    @IntRange(from = 0) addedCount: Int = 0,
    onIconClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.bottomBorder(strokeWidth = 1.dp, color = DrawerTitleBottomBorderColor)
    ) {
        Text(
            text = stringResource(titleRes),
            fontFamily = Inter,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            lineHeight = 31.sp,
            color = DrawerTitlesBasketColor,
            modifier = Modifier.clickable { onIconClick }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onIconClick) {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(titleRes),
                    tint = DrawerTitlesBasketIconsColor,
                )
            }
            if (addedCount > 0) {
                Text(
                    text = addedCount.toString(),
                    fontFamily = Inter,
                    fontWeight = FontWeight.W700,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(DrawerTitlesBasketIconsColor)
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 700)
@Composable
private fun FlyMenuPreview() {
    ElegantAppTheme {
        FlyMenu()
    }
}