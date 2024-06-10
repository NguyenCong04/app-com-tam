package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose

@Composable
fun GetLayoutAddCategoriesScreen(navController: NavHostController, db: AppDatabase) {
    var context = LocalContext.current

    var tenLoaiMon by remember {
        mutableStateOf("")
    }
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
                    onValueChange = {tenLoaiMon=it},
                    modifier = Modifier.fillMaxWidth(),
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
                    if ( tenLoaiMon.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Moi nhap thong tin",
                            Toast.LENGTH_SHORT
                        ).show()
                    }else{
                      db.loaiMonDAO().insert(
                          LoaiMonModel(
                              tenLoaiMon=tenLoaiMon
                          )
                      )
                      Toast.makeText(context,"Thêm loại món thành công", Toast.LENGTH_SHORT
                      ).show()
                      navController.popBackStack()
                  }
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
 //   GetLayoutAddCategoriesScreen(navController = rememberNavController(), db = db)
}