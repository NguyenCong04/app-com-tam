package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose

@Composable
fun GetLayoutAddCategoriesScreen() {
    ScaffoldCompose(onClickBack = { /*TODO*/ }) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(Color(0xff252121)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var LoaiMonAn by remember { mutableStateOf("") }

// TextField for input
            OutlinedTextField(
                value = LoaiMonAn,
                onValueChange = { LoaiMonAn = it },
                label = { Text("Nhập loại món ăn"
                        ,  style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.cairo_regular))))},
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .padding(start = 15.dp, end = 15.dp)
                    .height(65.dp)
                    .background(color = Color.White) // Set background color to white
                       , shape = RoundedCornerShape(4.dp)
            ) // Add rounded corners
Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            Button(
                onClick = {
                   // navController.navigate("home")
                },
                modifier = Modifier.size(170.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffFFB703)
                ),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(
                    text = "Thêm",

                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontWeight = FontWeight(600),
                    color = Color(0xffffffff),
                )
            }
        }
    }


}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutAddCategoriesScreen() {
    GetLayoutAddCategoriesScreen()
}