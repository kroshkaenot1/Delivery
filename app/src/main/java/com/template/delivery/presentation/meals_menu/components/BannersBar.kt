package com.template.delivery.presentation.meals_menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.template.delivery.R

@Composable
fun BannersBar(modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        item {
            Image(
                modifier = Modifier.size(width = 350.dp, height = 150.dp),
                painter = painterResource(id = R.drawable.banner1),
                contentDescription = null
            )
        }
        item {
            Image(
                modifier = Modifier.size(width = 350.dp, height = 150.dp),
                painter = painterResource(id = R.drawable.banner2),
                contentDescription = null
            )
        }
    }
}