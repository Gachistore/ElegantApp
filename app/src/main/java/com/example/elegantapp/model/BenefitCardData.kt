package com.example.elegantapp.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BenefitCardData(
    val icon: ImageVector,
    @StringRes val title: Int,
    @StringRes val description: Int
)
