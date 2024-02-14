package com.example.elegantapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArticleData(
    @DrawableRes val image: Int,
    val title: String,
    val onClick: () -> Unit = {}
)
