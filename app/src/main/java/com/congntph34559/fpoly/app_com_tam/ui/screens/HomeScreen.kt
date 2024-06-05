package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.R

data class Order(
    val id: String,
    val amount: String,
    val status: String
)

@Composable
fun GetLayoutHomeScreen(navController: NavHostController) {
    val orders = listOf(
        Order("CT2E22E", "162.000 đ", "Từ chối"),
        Order("CT2E22E", "157.000 đ", "Từ chối"),
        Order("CT2E22E", "162.000 đ", "Chấp nhận")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff252121))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 30.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today: 19-05-2024",
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 17.sp,
                    color = Color.White
                )
                Text(
                    text = "Số lượng đơn: ${orders.size}",
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 17.sp,
                    color = Color.White
                )
                Row {
                    Text(
                        text = "Doanh thu:",
                        fontFamily = FontFamily(Font(R.font.cairo_bold)),
                        fontSize = 17.sp,
                        color = Color.White
                    )
                    Text(
                        text = "320.000 đ",
                        fontFamily = FontFamily(Font(R.font.cairo_bold)),
                        fontSize = 17.sp,
                        color = Color("#fe724c".toColorInt()),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(top = 45.dp)
                ) {
                    items(orders) { order ->
                        OrderItem(order, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun OrderItem(order: Order, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(16.dp))
            .clickable {
                // Navigate to detail screen when clicking on the item
                navController.navigate("detail")
            }
            .padding(16.dp) // Add padding to the column
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Đơn hàng ${order.id}",
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Text(
                text = "||",
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(start = 50.dp)
            )
            Text(
                text = order.amount,
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trạng thái",
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(start = 8.dp) // Adjust padding
            )
            Text(
                text = order.status,
                color = if (order.status == "Chấp nhận") Color.Green else Color.Red,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(end = 8.dp) // Adjust padding
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingCart() {
    GetLayoutHomeScreen(rememberNavController())
}
