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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import com.example.elegantapp.ui.theme.Poppins
import com.example.elegantapp.ui.components.cards.BenefitOfElegantGrayCard
import com.example.elegantapp.ui.theme.JoinOurNewsDescriptionColor
import com.example.elegantapp.ui.theme.JoinOurNewsTitleColor
import com.example.elegantapp.ui.theme.JoinOurNewsBackgroundColor
import com.example.elegantapp.ui.theme.JoinOurNewsEmailAddressColor
import com.example.elegantapp.ui.theme.JoinOurNewsMailIconColor
import com.example.elegantapp.ui.theme.JoinOurNewsSignupColor
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
        JoinOurNes(
            modifier = Modifier
                .fillMaxWidth()
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
            fontFamily = Poppins,
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
                fontFamily = Poppins,
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
    Column(
        modifier = modifier.background(SalesUpSaleBackgroundColor)
    ) {
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
                    fontFamily = Poppins,
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
                fontFamily = Poppins,
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
private fun JoinOurNes(
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = modifier.background(color = JoinOurNewsBackgroundColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                vertical = 95.dp,
                horizontal = dimensionResource(R.dimen.default_32_padding)
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.join_out_newsletter),
                    fontFamily = Poppins,
                    fontWeight = FontWeight.W600,
                    fontSize = 28.sp,
                    lineHeight = 32.sp,
                    color = JoinOurNewsTitleColor,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.default_8_padding)))
                Text(
                    text = stringResource(R.string.sign_up_for_details),
                    fontFamily = Inter,
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = JoinOurNewsDescriptionColor,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.height(dimensionResource(R.dimen.default_32_padding)))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = {
                    Text(
                        text = stringResource(R.string.email_address),
                        fontFamily = Inter,
                        fontWeight = FontWeight.W500,
                        fontSize = 15.sp,
                        color = JoinOurNewsEmailAddressColor
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Mail,
                        contentDescription = null,
                        tint = JoinOurNewsMailIconColor
                    )
                },
                trailingIcon = {
                    TextButton(onClick = { text = "" }) {
                        Text(
                            text = stringResource(R.string.signup),
                            fontFamily = Inter,
                            fontWeight = FontWeight.W500,
                            fontSize = 15.sp,
                            color = JoinOurNewsSignupColor
                        )
                    }
                },
                shape = RoundedCornerShape(7.dp)
            )
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

