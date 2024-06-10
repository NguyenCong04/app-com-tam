package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.congntph34559.fpoly.app_com_tam.R

@Preview
@Composable
fun GetLayoutHoiTroScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff252121)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 55.dp, top = 20.dp, end = 20.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.zalo),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 60.dp)
                )
            }

            Text(
                text = "0348345082",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 100.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 55.dp, top = 20.dp, end = 20.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.gmail),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 60.dp)
                )
            }

            Text(
                text = "trongcuong571@gmail.com",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 55.dp, top = 20.dp, end = 20.dp
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.phone),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 60.dp)
                )
            }

            Text(
                text = "0348345082",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 100.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            )
        }
    }
}

