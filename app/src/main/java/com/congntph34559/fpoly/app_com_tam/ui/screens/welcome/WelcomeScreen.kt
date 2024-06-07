package com.congntph34559.fpoly.app_com_tam.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV
import kotlinx.coroutines.delay

@Composable
fun GetLayoutWelcome(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(ROUTE_MAIN_NAV.login.name) {
            popUpTo(ROUTE_MAIN_NAV.welcome.name) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xff282222)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_max),
            contentDescription = null,
            modifier = Modifier.size(300.dp, 300.dp)
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewWelcome() {
    GetLayoutWelcome(navController = rememberNavController())
}