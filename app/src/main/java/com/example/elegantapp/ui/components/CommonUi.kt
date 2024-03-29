package com.example.elegantapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elegantapp.R
import androidx.compose.ui.text.TextStyle
import com.example.elegantapp.ui.theme.ElegantAppTheme
import com.example.elegantapp.ui.theme.Popins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElegantTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                text = stringResource(id = R.string.topappbar_app_name),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Popins,
                ),
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_shopping_bag),
                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun ElegantTopAppBarPreview() {
    ElegantAppTheme {
        ElegantTopAppBar()
    }
}