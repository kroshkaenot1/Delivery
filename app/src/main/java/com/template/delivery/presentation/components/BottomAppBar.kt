package com.template.delivery.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.template.delivery.R

@Composable
fun BottomAppBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(modifier = modifier.background(color = Color(ContextCompat.getColor(context, R.color.bottomAppBar)))
        .padding(top = 5.dp), verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(width = 40.dp, height = 40.dp),
                painter = painterResource(id = R.drawable.ic_menu_selected),
                contentDescription = null
            )
            Text(text = "Меню", color = Color(ContextCompat.getColor(context, R.color.selected_Nav_Bar_Text)))
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(width = 35.dp, height = 35.dp),
                painter = painterResource(id = R.drawable.ic_profile_not_selected),
                contentDescription = null
            )
            Text(text = "Профиль",color = Color(ContextCompat.getColor(context, R.color.not_Selected_Nav_Bar_Text)))
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(width = 35.dp, height = 35.dp),
                painter = painterResource(id = R.drawable.ic_card_not_selected),
                contentDescription = null
            )
            Text(text = "Корзина",color = Color(ContextCompat.getColor(context, R.color.not_Selected_Nav_Bar_Text)))
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}