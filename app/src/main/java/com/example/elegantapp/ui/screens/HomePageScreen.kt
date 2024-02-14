package com.example.elegantapp.ui.screens

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.data.ElegantLists
import com.example.elegantapp.model.ArticleData
import com.example.elegantapp.model.BenefitData
import com.example.elegantapp.model.ProductData
import com.example.elegantapp.ui.components.Footer
import com.example.elegantapp.ui.components.cards.ArticleCard
import com.example.elegantapp.ui.components.cards.HomePageProductCategoryCard
import com.example.elegantapp.ui.components.cards.ProductCard
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.FooterColor
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Popins
import com.example.elegantapp.ui.components.cards.BenefitOfElegantGrayCard
import com.example.elegantapp.ui.theme.LinkButtonWithArrowColor
import com.example.elegantapp.ui.theme.SalesUpSaleBackgroundColor
import com.example.elegantapp.ui.theme.SalesUpSaleColor
import com.example.elegantapp.ui.theme.SalesUpSaleDescriptionColor
import com.example.elegantapp.ui.theme.SalesUpSaleTitleColor

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
        Categories(
            modifier = Modifier
                .padding(
                    start = dimensionResource(R.dimen.home_page_start_padding),
                    end = dimensionResource(R.dimen.home_page_end_padding)
                )
                .fillMaxWidth()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.default_32_padding)))
        NewArrivals(
            productList = ElegantLists.NewArrivals,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.default_32_padding)))
        Benefits(
            benefitsList = ElegantLists.Benefits,
            modifier = Modifier.padding(dimensionResource(R.dimen.default_32_padding))
        )
        SalesUp(
            modifier = Modifier.fillMaxWidth()
        )
        Articles(
            articles = ElegantLists.Articles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.default_40_padding),
                    horizontal = dimensionResource(R.dimen.default_32_padding)
                )
        )

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
private fun Categories(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        // TODO: переделать в лист
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
}

@Composable
private fun NewArrivals(
    productList: List<ProductData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.default_32_padding),
                end = dimensionResource(R.dimen.default_32_padding),
            )
        ) {
            Text(
                text = stringResource(R.string.new_arrivals),
                fontFamily = Popins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 33.sp,
                lineHeight = 35.sp,
                color = Color.Black
            )
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.default_8_padding)))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(dimensionResource(R.dimen.default_32_padding))
        ) {
            items(productList) { product ->
                ProductCard(
                    product,
                    modifier = Modifier
                        .width(231.dp)
                        .height(392.dp)
                )
            }
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.default_8_padding)))
        LinkButtonWithArrow(
            text = R.string.more_products,
            fontSize = 13,
            color = FooterColor,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.default_32_padding),
                end = dimensionResource(R.dimen.default_32_padding),
            )
        )
    }
}

@Composable
private fun Benefits(
    benefitsList: List<BenefitData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row {
            BenefitOfElegantGrayCard(
                benefitData = benefitsList[0],
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.default_8_padding)))
            BenefitOfElegantGrayCard(
                benefitData = benefitsList[1],
                modifier = Modifier
                    .weight(1f)
            )
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.default_24_padding)))
        Row {
            BenefitOfElegantGrayCard(
                benefitData = benefitsList[2],
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.default_8_padding)))
            BenefitOfElegantGrayCard(
                benefitData = benefitsList[3],
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
private fun SalesUp(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.background(SalesUpSaleBackgroundColor)
    ){
        Image(
            painter = painterResource(R.drawable.sales_sofa),
            contentDescription = stringResource(R.string.sales_image_content_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(367.dp)
        )
        Column(
            modifier = Modifier
                .padding(
                    vertical = 58.dp,
                    horizontal = dimensionResource(R.dimen.default_32_padding)
                )
        ) {
            Column {
                Text(
                    text = stringResource(R.string.sale_up_to_text, "35%"),
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = SalesUpSaleColor
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.default_16_padding)))
                Text(
                    text = "HUNDREDS of \n" +
                            "New lower prices!",
                    fontFamily = Popins,
                    fontWeight = FontWeight.W600,
                    fontSize = 32.sp,
                    lineHeight = 36.sp,
                    color = SalesUpSaleTitleColor
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.default_16_padding)))
                Text(
                    text = "It’s more affordable than ever to give every room in your home a stylish makeover",
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    lineHeight = 24.sp,
                    color = SalesUpSaleDescriptionColor
                )
            }
            Spacer(Modifier.height(dimensionResource(R.dimen.default_24_padding)))
            LinkButtonWithArrow(
                text = R.string.shop_now,
                fontSize = 13,
                color = LinkButtonWithArrowColor
            )
        }
    }
}

@Composable
private fun Articles(
    articles: List<ArticleData>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier.height(38.dp)
        ) {
            Text(
                text = stringResource(R.string.articles),
                fontFamily = Popins,
                fontWeight = FontWeight.W500,
                fontSize = 32.sp,
                lineHeight = 36.sp,
                color = Color.Black
            )
            Spacer(Modifier.weight(1f))
            Column(
                verticalArrangement = Arrangement.Bottom
            ) {
                Spacer(Modifier.weight(1f))
                LinkButtonWithArrow(
                    text = R.string.more_articles,
                    fontSize = 13,
                    color = LinkButtonWithArrowColor
                )
            }
        }
        Spacer(Modifier.height(40.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.default_24_padding))
        ) {
            articles.forEach {
                ArticleCard(
                    articleData = it,
                )
            }
        }
    }
}

@Composable
fun LinkButtonWithArrow(
    @StringRes text: Int,
    fontSize: Int,
    color: Color,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .bottomBorder(1.dp, FooterColor)
            .clickable { onClick }
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
        }
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx / 2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width, y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)


//@Preview(showBackground = true)
//@Composable
//private fun HomePageScreenPreview() {
//    ElegantAppTheme {
//        HomePageScreen()
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun HomePageNewArrivalsPreview() {
//    ElegantAppTheme {
//        NewArrivals(
//            productList = ElegantLists.NewArrivals,
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
private fun HomePageSalesUpPreview() {
    ElegantAppTheme {
        SalesUp()
    }
}

