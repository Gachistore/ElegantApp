package com.example.elegantapp.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.data.ElegantLists
import com.example.elegantapp.model.ArticleData
import com.example.elegantapp.ui.screens.LinkButtonWithArrow
import com.example.elegantapp.ui.theme.ArticleTitleColor
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.LinkButtonWithArrowColor

@Composable
fun ArticleCard(
    articleData: ArticleData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Image(
            painter = painterResource(articleData.image),
            contentDescription = "Article image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(283.dp)
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.default_16_padding)))
        Text(
            text = articleData.title,
            fontFamily = Inter,
            fontWeight = FontWeight.W600,
            fontSize = 15.sp,
            lineHeight = 24.sp,
            color = ArticleTitleColor
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.default_8_padding)))
        LinkButtonWithArrow(
            text = R.string.read_more,
            fontSize = 13,
            color = LinkButtonWithArrowColor
        )
    }
}

@Preview
@Composable 
private fun ArticleCardPreview() {
    ElegantAppTheme {
        val data = ElegantLists.Articles[0]
        ArticleCard(articleData = data)
    }
}