package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV

@Composable
fun GetLayoutDetailDonHang(navController: NavHostController) {
    var context = LocalContext.current
    ScaffoldCompose(onClickBack = {
        Toast.makeText(context, "Layout Detail", Toast.LENGTH_LONG).show()
        navController.navigate(ROUTE_MAIN_NAV.home.name)
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xff252121)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Detail Don hang")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingDetailDonHang() {
    GetLayoutDetailDonHang(navController = rememberNavController())
}