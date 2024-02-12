package com.example.elegantapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Lock
import com.example.elegantapp.R
import com.example.elegantapp.model.BenefitCardData
import com.example.elegantapp.model.ProductCardData
import com.example.elegantapp.ui.components.cards.BenefitOfElegantGrayCard

object ElegantLists {
    val NewArrivals = listOf(
        ProductCardData(
            R.drawable.kitchen_toster,
            true,
            10,
            true,
            4,
            "Toster",
            100,
            111
        ),
        ProductCardData(
            R.drawable.test_sofa,
            false,
            20,
            false,
            5,
            "Best Sofa",
            200,
            250
        ),
        ProductCardData(
            R.drawable.living_room_chair,
            true,
            0,
            false,
            1,
            "Chilling Chair",
            50
        ),
        ProductCardData(
            R.drawable.bedroom_nightstand,
            true,
            50,
            true,
            3,
            "NightStand",
            300,
            600
        )

    )
    val Benefits = listOf(
        BenefitCardData(
            Icons.Outlined.DirectionsCar,
            R.string.free_shipping,
            R.string.free_shipping_description
        ),
        BenefitCardData(
            Icons.Outlined.AttachMoney,
            R.string.money_back,
            R.string.money_back_description
        ),
        BenefitCardData(
            Icons.Outlined.Lock,
            R.string.secure_payments,
            R.string.secure_payments_description
        ),
        BenefitCardData(
            Icons.Outlined.Call,
            R.string.allday_support,
            R.string.allday_support_description
        )
    )
}