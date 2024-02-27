package com.example.elegantapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.material.icons.filled.ViewColumn
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.elegantapp.R
import com.example.elegantapp.data.ElegantLists
import com.example.elegantapp.model.ProductData
import com.example.elegantapp.ui.components.Footer
import com.example.elegantapp.ui.components.cards.ProductCardHorizontal
import com.example.elegantapp.ui.components.cards.ProductCardVertical
import com.example.elegantapp.ui.theme.Black200
import com.example.elegantapp.ui.theme.Black900
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Neutral03
import com.example.elegantapp.ui.theme.Neutral04
import com.example.elegantapp.ui.theme.Neutral07
import com.example.elegantapp.ui.theme.Poppins
import kotlin.math.ceil

enum class SortBy(val type: String) {
    Price("Price"),
    Discount("Discount"),
    Rating("Rating"),
    Title("Title")
}

@Composable
fun ShopPageScreen(
    navController: NavHostController,
    room: String
) {

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
        ProductsList(
            room = room,
            productsList = ElegantLists.NewArrivals,
            options = listOf(
                SortBy.Price.type,
                SortBy.Discount.type,
                SortBy.Title.type,
                SortBy.Rating.type
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
        )


        JoinOurNes(
            modifier = Modifier
                .fillMaxWidth()
        )
        Footer(navController = navController)
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

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalAnimationApi::class
)
@Composable
private fun ProductsList(
    room: String,
    productsList: List<ProductData>?,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var isVertical by rememberSaveable { mutableStateOf(true) }
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("Sort by") }
    var visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
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
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    OutlinedButton(
                        onClick = { isVertical = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isVertical) Color(0xFFF3F5F7) else Color.White,
                            contentColor = if (isVertical) Neutral07 else Neutral04,
                        ),
                        border = BorderStroke(1.dp, Black200),
                        contentPadding = PaddingValues(all = 4.dp),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_vertical_lines),
                            contentDescription = "Column view of products"
                        )
                    }
                    OutlinedButton(
                        onClick = { isVertical = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isVertical) Color(0xFFF3F5F7) else Color.White,
                            contentColor = if (!isVertical) Neutral07 else Neutral04,
                        ),
                        border = BorderStroke(1.dp, Black200),
                        contentPadding = PaddingValues(all = 4.dp),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_horizontal_lines),
                            contentDescription = "Row view of products"
                        )
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = room,
                    fontFamily = Inter,
                    fontWeight = W600,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color.Black
                )
                Spacer(Modifier.weight(1f))
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .menuAnchor()
                    ) {
                        Text(
                            text = selectedOptionText,
                            fontFamily = Inter,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = Black900
                        )
                        Spacer(Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "Sort by",
                            tint = Black900,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.width(110.dp)
                    ) {
                        options.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = selectionOption,
                                        fontFamily = Inter,
                                        fontWeight = W600,
                                        fontSize = 16.sp,
                                        lineHeight = 24.sp,
                                        color = Black900
                                    )
                                },
                                onClick = {
                                    selectedOptionText = selectionOption
                                    expanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                modifier = Modifier
                                    .topBorder(1.dp, Neutral04)
                                    .bottomBorder(1.dp, Neutral04)
                            )
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
            ),
            exit = fadeOut(
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
            )
        ) {
            if (productsList.isNullOrEmpty()) {
                Text(
                    text = "There is no products in our shop. Sorry (",
                    fontFamily = Inter,
                    fontWeight = W600,
                    fontSize = 36.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else {
                if (isVertical) {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(152.dp),
                        modifier = Modifier
                            .padding(bottom = 32.dp, top = 16.dp)
                            .heightIn(max = ((281 * productsList.size) + 16 * (productsList.size - 1)).dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        userScrollEnabled = false
                    ) {
                        itemsIndexed(
                            when(selectedOptionText) {
                                SortBy.Price.type -> productsList.sortedBy { it.price }
                                SortBy.Rating.type -> productsList.sortedByDescending { it.rating }
                                SortBy.Title.type -> productsList.sortedBy { it.title }
                                SortBy.Discount.type -> productsList.sortedByDescending { it.discount }
                                else -> productsList
                            }
                        ) { index, product ->
                            ProductCardVertical(
                                data = product,
                                imageSizeDp = 203,
                                modifier = Modifier
                                    .height(281.dp)
                                    .animateEnterExit(
                                        enter = slideInVertically(
                                            animationSpec = spring(
                                                stiffness = Spring.StiffnessVeryLow,
                                                dampingRatio = Spring.DampingRatioLowBouncy
                                            ),
                                            initialOffsetY = { it * (index + 1) }
                                        )
                                    )
                            )
                        }
                        visibleState = MutableTransitionState(false).apply {
                            targetState = false
                        }
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .padding(vertical = 32.dp)
                            .height((250 * productsList.size + (productsList.size - 1) * 16).dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        userScrollEnabled = false
                    ) {
                        itemsIndexed(
                            when(selectedOptionText) {
                                SortBy.Price.type -> productsList.sortedBy { it.price }
                                SortBy.Rating.type -> productsList.sortedByDescending { it.rating }
                                SortBy.Title.type -> productsList.sortedBy { it.title }
                                SortBy.Discount.type -> productsList.sortedByDescending { it.discount }
                                else -> productsList
                            }
                        ) { index, product ->
                            ProductCardHorizontal(
                                data = product,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)
                                    .animateEnterExit(
                                        enter = slideInVertically(
                                            animationSpec = spring(
                                                stiffness = Spring.StiffnessVeryLow,
                                                dampingRatio = Spring.DampingRatioLowBouncy
                                            ),
                                            initialOffsetY = { it * (index + 1) }
                                        )
                                    )
                            )
                        }
                        visibleState = MutableTransitionState(false).apply { targetState = true }
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(80.dp),
                border = BorderStroke(1.dp, Neutral07)
            ) {
                Text(
                    text = stringResource(R.string.show_more),
                    fontFamily = Inter,
                    fontWeight = W500,
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
                    color = Neutral07,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(Modifier.height(48.dp))
    }
}


@Preview(showBackground = true)
@Composable
private fun ShopPageScreenPreview() {
    val navController: NavHostController = rememberNavController()
    ElegantAppTheme {
        ShopPageScreen(navController = navController, "Living room")
    }
}