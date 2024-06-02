package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.congntph34559.fpoly.app_com_tam.R

@Composable
fun GetLayoutQuanLyCategoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff252121)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        )
        {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
            Text(
                text = "QuanLyScreen",
                color = Color.White
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutQuanLyCategoriesScreen() {
    GetLayoutQuanLyCategoriesScreen()
}