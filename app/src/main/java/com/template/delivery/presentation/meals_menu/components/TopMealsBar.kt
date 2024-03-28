package com.template.delivery.presentation.meals_menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.template.delivery.R

@Composable
fun TopMealsBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "Москва",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Icon(
            modifier = Modifier.padding(start = 10.dp),
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = null
        )
        Spacer(modifier = modifier.weight(1f))
        Image(
            modifier = Modifier.padding(end = 20.dp)
                .size(width = 30.dp, height = 30.dp),
            painter = painterResource(id = R.drawable.ic_qr_scan),
            contentDescription = null
        )
    }
}