package com.example.elegantapp.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter
import com.example.elegantapp.ui.theme.Neutral02
import com.example.elegantapp.ui.theme.Neutral04
import com.example.elegantapp.ui.theme.Neutral07

@Composable
fun GrayContactUsCard(
    icon: ImageVector,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(Neutral02)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 9.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Neutral07,
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = title,
                fontFamily = Inter,
                fontWeight = W700,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                color = Neutral04
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = description,
                fontFamily = Inter,
                fontWeight = W600,
                fontSize = 16.sp,
                lineHeight = 25.sp,
                color = Neutral07,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun GrayContactUsCardPreview() {
    ElegantAppTheme {
        GrayContactUsCard(
            icon = Icons.Outlined.Storefront,
            title = "Address",
            description = "234 Hai Trieu, Ho Chi Minh City," +
                    "Viet Nam",
            modifier = Modifier.fillMaxWidth()
        )
    }
}