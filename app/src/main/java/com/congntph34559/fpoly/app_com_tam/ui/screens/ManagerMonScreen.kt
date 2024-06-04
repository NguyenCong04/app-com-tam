package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose

@Composable
fun GetLayoutManagerMonScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff252121))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().selectable(
                    selected = true,
                    onClick = {

                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_max),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 50.dp)
                )
                Text(
                    text = "Thêm món ăn",
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            SpacerHeightCompose(height = 15)
            Row(
                modifier = Modifier.fillMaxWidth().selectable(
                    selected = true,
                    onClick = {

                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_max),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 50.dp)
                )
                Text(
                    text = "Sửa món ăn",
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            SpacerHeightCompose(height = 15)
            Row(
                modifier = Modifier.fillMaxWidth().selectable(
                    selected = true,
                    onClick = {

                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_max),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp, 50.dp)
                )
                Text(
                    text = "Xoá món ăn",
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }

    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingManagerMonScreen() {
    GetLayoutManagerMonScreen()
}