package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.OrderModel
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.screens.dishorder.YourViewModel


@Composable
fun GetLayoutHomeScreen(navController: NavHostController,viewModel: YourViewModel) {

    if(viewModel.getAll()?.isEmpty() == true) {
        viewModel.insertOrder(order =
        OrderModel(1,"CBBBB1",167f,false),
        )
        viewModel.insertOrder(order =
        OrderModel(2,"CBBBB2",177f,true),
        )
        viewModel.insertOrder(order =
        OrderModel(3,"CBBBB3",187f,false),
        )
        viewModel.insertOrder(order =
        OrderModel(4,"CBBBB4",197f,true),
        )
        viewModel.insertOrder(order =
        OrderModel(5,"CBBBB5",267f,false),
        )

    }else {
        null
    }

//    val orders = viewModel.getAll()
    var orders by remember {
        mutableStateOf(viewModel.getAll())
    }
    Log.e("zzz", "GetLayoutHomeScreen: $orders", )
//    val orders = listOf(
//        OrderModel(1,"CT2E22E", "142.000 đ", false),
//        OrderModel(2,"CT2E22E", "157.000 đ", false),
//        OrderModel(3,"CT2E22E", "192.000 đ", true)
//    )
    val context = LocalContext.current
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
                    text = "Số lượng đơn: ${orders?.size}",
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
                   items(orders ?: emptyList()) {
                       OrderItem(order = it, navController = navController,viewModel)
                   }
                }
            }
        }
    }
}


@Composable
fun OrderItem(order: OrderModel, navController: NavHostController,viewModel: YourViewModel) {
    var newStatus by remember { mutableStateOf(order.status) }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(16.dp))
            .clickable {
                // Navigate
                // to detail screen when clicking on the item
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
                text = "Đơn hàng ${order.tenDonhang}",
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
                text = "${order.price}",
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
                text = if (newStatus) "Chấp nhận" else "Từ chối",
                color = if (newStatus) Color.Green else Color.Red,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .padding(end = 8.dp) // Adjust padding
                    .clickable {
                        newStatus = !newStatus
//                        if(newStatus === order.IdOrder)
                        val e = viewModel.getById(order.IdOrder)
                        e?.let {
                            it.tenDonhang = order.tenDonhang
                            it.price= order.price
                            it.status = newStatus
                            viewModel.updateOrder(it)
                        }
                        Log.e("bbb", "OrderItem: $e", )
                    }
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingCart() {
//    GetLayoutHomeScreen(rememberNavController(), db)
}