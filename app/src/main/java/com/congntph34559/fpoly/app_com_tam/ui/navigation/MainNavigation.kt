package com.congntph34559.fpoly.app_com_tam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutDetailDonHang
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutLoginScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutRegisterScreen

enum class ROUTE_MAIN_NAV {
    login,
    register,
    home,
    detail
}

@Composable
fun AppNavigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = ROUTE_MAIN_NAV.login.name) {
        composable(ROUTE_MAIN_NAV.login.name) { GetLayoutLoginScreen(navController) }
        composable(ROUTE_MAIN_NAV.register.name) { GetLayoutRegisterScreen(navController) }
        composable(ROUTE_MAIN_NAV.home.name) {
            GetLayoutButtonTopBarNavigation(
                navController
            )
        }
        composable(ROUTE_MAIN_NAV.detail.name) { GetLayoutDetailDonHang(navController) }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingGetLayoutAppNavigation() {

}