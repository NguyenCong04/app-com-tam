package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV

data class FoodItem(val id: String, val name: String, val price: String, val quantity: String)

@Composable
fun GetLayoutDetailDonHang(navController: NavHostController) {
    val context = LocalContext.current
    val mainDishes = listOf(
        FoodItem("1", "Sườn bì", "56k", "02"),
        FoodItem("2", "Bì trứng", "56k", "02"),
        FoodItem("3", "Bì chả", "56k", "02")
    )
    val toppings = listOf(
        FoodItem("1", "Bì chả", "56k", "02"),
        FoodItem("2", "Bì chả", "56k", "02")
    )

    ScaffoldCompose(onClickBack = {
        Toast.makeText(context, "Layout Detail", Toast.LENGTH_LONG).show()
        navController.navigate(ROUTE_MAIN_NAV.home.name)
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xff252121)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { /* Xử lý sự kiện khi nhấn "Xác nhận" */ },
                    modifier = Modifier
                        .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(16.dp))
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text("Xác nhận", color = Color.White,fontFamily = FontFamily(Font(R.font.cairo_bold))
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(
                    onClick = { /* Xử lý sự kiện khi nhấn "Hủy bỏ" */ },
                    modifier = Modifier
                        .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(16.dp))
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text("Hủy bỏ", color = Color.White,fontFamily = FontFamily(Font(R.font.cairo_bold))
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 30.dp, end = 20.dp)
            ) {
                item {
                    Text(
                        text = "Món chính",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.cairo_bold))

                    )
                }
                items(mainDishes) { dish ->
                    FoodItemRow(dish)
                }
                
                item {
                    Spacer(modifier = Modifier.height(30.dp)) // Add space before Divider
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
                item {
                    Text(
                        text = "Topping",
                        color = Color.White,
                        fontSize = 24.sp,
                        modifier = Modifier.offset(y = 10.dp),
                        fontFamily = FontFamily(Font(R.font.cairo_bold))

                    )
                }
                items(toppings) { topping ->
                    FoodItemRow(topping)
                }
                item {
                    Spacer(modifier = Modifier.height(30.dp)) // Add space before Divider
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(100.dp))
                    Column(modifier = Modifier.fillMaxWidth().offset(y = -40.dp, x = 10.dp)) {
                        Text(
                            text = "Số nhà : 54",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Đường 14",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Phường : Đông Hưng Thuận",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Quận : 12",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Thành Phố: Hồ Chí Minh",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                    }
                }
                item {
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(80.dp))
                    Column(modifier = Modifier.fillMaxWidth().offset(y = -50.dp, x = 10.dp)) {
                        Text(
                            text = "Giờ : 13h45",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "SDT: 0344758585",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Tổng số lượng món ăn : 3",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Tổng số lượng topping : 2",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                        Text(
                            text = "Tổng tiền : 153k",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_bold))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FoodItemRow(foodItem: FoodItem) {
    Row(
        modifier = Modifier
            .width(366.dp)
            .height(92.dp)
            .padding(top = 30.dp)
            .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = foodItem.id,
                modifier = Modifier.padding(end = 16.dp),
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.cairo_bold))
            )
            Image(
                painter = painterResource(id = R.drawable.mon_an_1),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .offset(x = 10.dp)
            )
        }
        Column(
            modifier = Modifier.padding(15.dp, end = 125.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = foodItem.name,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.cairo_bold))

            )
            Text(
                text = foodItem.price,
                color = Color("#e46948".toColorInt()),
                fontFamily = FontFamily(Font(R.font.cairo_bold))

            )
        }
        Text(
            text = foodItem.quantity,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.cairo_bold))

        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingDetailDonHang() {
    GetLayoutDetailDonHang(navController = rememberNavController())
}
