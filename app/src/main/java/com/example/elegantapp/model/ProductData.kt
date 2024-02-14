package com.example.elegantapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntRange

data class ProductData(
    @DrawableRes val image: Int,
    val isNew: Boolean = false,
    @IntRange(from = 0, to = 100) val discount: Int = 0,
    var isLiked: Boolean = false,
    @IntRange(from = 0, to = 5) val rating: Int,
    val title: String,
    val price: Int,
    val previousPrice: Int = 0
)
