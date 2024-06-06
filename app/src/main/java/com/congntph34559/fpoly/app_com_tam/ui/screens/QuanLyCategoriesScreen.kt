package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV

@Composable
fun GetLayoutQuanLyCategoriesScreen(navHostController: NavHostController) {
    ScaffoldCompose(onClickBack = { /*TODO*/ }) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(Color(0xff252121)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 26.dp)

                    .clickable {
                        println("Row clicked")
                        navHostController.navigate(ROUTE_MAIN_NAV.addCategory.name)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(
                    text = "Thêm loại món ăn",
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 26.dp)
                    .clickable {
                        println("Row clicked")
                        navHostController.navigate(ROUTE_MAIN_NAV.listCategoryUpdate.name)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(
                    text = "Sửa loại món ăn",
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 26.dp)

                    .clickable {
                        println("Row clicked")
                        navHostController.navigate(
                            ROUTE_MAIN_NAV.listCategoryDelete.name
                        )
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(
                    text = "Xoá loại món ăn",
                    color = Color.White
                )
            }
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutQuanLyCategoriesScreen() {
    GetLayoutQuanLyCategoriesScreen(navHostController = rememberNavController())
}