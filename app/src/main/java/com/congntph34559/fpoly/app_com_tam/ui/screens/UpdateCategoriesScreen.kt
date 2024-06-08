package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV

@Composable
fun GetLayoutUpdateCategoriesScreen(navController: NavHostController,IdLoaiMon: Int?) {
    var context = LocalContext.current
    var db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "Loaimon"
    ).allowMainThreadQueries().build()
    var catego: LoaiMonModel? = null
    fun getCategory() {
        if (IdLoaiMon != null) {
            catego = db.loaiMonDAO().getById(IdLoaiMon)
        }
    }
    getCategory()
    var tenLoaiMon by remember {
        mutableStateOf(catego?.tenLoaiMon ?: "")
    }

    Log.d("zzzzzzz", "GetLayoutUpdateStudent: ${catego!!.tenLoaiMon}")

    ScaffoldCompose(onClickBack = {
        navController.popBackStack()
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(Color(0xff252121)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp).fillMaxWidth()
            ) {

                TextField(

                    value = tenLoaiMon,
                    onValueChange = {
                        tenLoaiMon = it
                    },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedPlaceholderColor = Color.Black,
                        unfocusedPlaceholderColor = Color.Gray,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White
                    ),
                    placeholder = {
                        Text(
                            text = "Nhập loại món ăn",
                            color = Color.Black,
                            fontWeight = FontWeight(600),
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.cairo_regular)),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.cairo_regular))
                            )
                        )
                    },
                    shape = RoundedCornerShape(size = 8.dp),
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.cairo_regular))
                    )

                )
            }
Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            Button(

                    onClick = {
                        if (tenLoaiMon.isNotBlank()) {
                            catego?.let {
                                it.tenLoaiMon = tenLoaiMon
                                db.loaiMonDAO().update(it)  // Cập nhật cơ sở dữ liệu
                                Toast.makeText(
                                    context,
                                    "Sửa loại món thành công",
                                    Toast.LENGTH_SHORT
                                ).show()
                                navController.navigate(ROUTE_MAIN_NAV.listCategoryUpdate.name) {
                                    popUpTo(ROUTE_MAIN_NAV.listCategoryUpdate.name) { inclusive = true }
                                }
                            }
                    }
                    else {
                        Toast.makeText(
                            context,
                            "Please enter information",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.size(170.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffFFB703)
                ),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(
                    text = "Cập Nhập",
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
fun GreetingLayoutUpdateCategoriesScreen() {
    GetLayoutUpdateCategoriesScreen(navController = rememberNavController(),IdLoaiMon=0)
}