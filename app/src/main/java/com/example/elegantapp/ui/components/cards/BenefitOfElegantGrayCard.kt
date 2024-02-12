package com.example.elegantapp.ui.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import com.example.elegantapp.model.BenefitCardData
import com.example.elegantapp.ui.theme.BenefitOfElegantGrayCardColor
import com.example.elegantapp.ui.theme.BenefitOfElegantGrayCardDescriptionColor
import com.example.elegantapp.ui.theme.BenefitOfElegantGrayCardIconColor
import com.example.elegantapp.ui.theme.BenefitOfElegantGrayCardTitleColor
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Inter

@Composable
fun BenefitOfElegantGrayCard(
    benefitData: BenefitCardData,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
          containerColor = BenefitOfElegantGrayCardColor
        ),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(R.dimen.benefit_content_vertical_padding),
                    horizontal = dimensionResource(R.dimen.benefit_content_horizontal_padding)
                )
        ) {
            Icon(
                imageVector = benefitData.icon,
                contentDescription = null,
                tint = BenefitOfElegantGrayCardIconColor,
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.default_16_padding)))
            Column {
                Text(
                    text = stringResource(benefitData.title),
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    lineHeight = 19.sp,
                    color = BenefitOfElegantGrayCardTitleColor
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.default_8_padding)))
                Text(
                    text = stringResource(benefitData.description),
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 19.sp,
                    color = BenefitOfElegantGrayCardDescriptionColor
                )
            }
        }
    }
}

@Preview
@Composable
private fun BenefitOfElegantGrayCard() {
    ElegantAppTheme {
        val benefitData = BenefitCardData(
            icon = Icons.Filled.DirectionsCar,
            title = R.string.secure_payments,
            description = R.string.secure_payments_description
        )
        BenefitOfElegantGrayCard( benefitData )
    }
}