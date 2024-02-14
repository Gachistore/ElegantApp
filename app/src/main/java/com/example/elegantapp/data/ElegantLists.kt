package com.example.elegantapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Lock
import com.example.elegantapp.R
import com.example.elegantapp.model.ArticleData
import com.example.elegantapp.model.BenefitData
import com.example.elegantapp.model.ProductData

object ElegantLists {
    val NewArrivals = listOf(
        ProductData(
            R.drawable.kitchen_toster,
            true,
            10,
            true,
            4,
            "Toster",
            100,
            111
        ),
        ProductData(
            R.drawable.test_sofa,
            false,
            20,
            false,
            5,
            "Best Sofa",
            200,
            250
        ),
        ProductData(
            R.drawable.living_room_chair,
            true,
            0,
            false,
            1,
            "Chilling Chair",
            50
        ),
        ProductData(
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
        BenefitData(
            Icons.Outlined.DirectionsCar,
            R.string.free_shipping,
            R.string.free_shipping_description
        ),
        BenefitData(
            Icons.Outlined.AttachMoney,
            R.string.money_back,
            R.string.money_back_description
        ),
        BenefitData(
            Icons.Outlined.Lock,
            R.string.secure_payments,
            R.string.secure_payments_description
        ),
        BenefitData(
            Icons.Outlined.Call,
            R.string.allday_support,
            R.string.allday_support_description
        )
    )
    val Articles = listOf(
        ArticleData(
            image = R.drawable.first_article,
            title = "7 ways to decor your home"
        ),
        ArticleData(
            image = R.drawable.second_article,
            title = "Kitchen organization"
        ),
        ArticleData(
            image = R.drawable.third_article,
            title = "Decor your bedroom"
        )
    )
}