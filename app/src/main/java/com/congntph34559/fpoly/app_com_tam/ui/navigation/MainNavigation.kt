package com.congntph34559.fpoly.app_com_tam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutAddCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutAddMonScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutDeleteCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutDetailDonHang
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutEditCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutListMonDelete
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutListMonUpdateScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutLoginScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutRegisterScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutUpdateCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutUpdateMonScreen

enum class ROUTE_MAIN_NAV {
    login,
    register,
    home,
    detail,
    addCategory,
    listCategoryDelete,
    updateCategory,
    listCategoryUpdate,
    addMon,
    updateMon,
    listMonUpdate,
    listMonDelete,
}

@Composable
fun AppNavigation() {
    var navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTE_MAIN_NAV.login.name
    ) {
        composable(ROUTE_MAIN_NAV.login.name) {
            GetLayoutLoginScreen(
                navController
            )
        }
        composable(ROUTE_MAIN_NAV.register.name) {
            GetLayoutRegisterScreen(
                navController
            )
        }
        composable(ROUTE_MAIN_NAV.home.name) {
            GetLayoutButtonTopBarNavigation(
                navController
            )
        }
        composable(ROUTE_MAIN_NAV.detail.name) {
            GetLayoutDetailDonHang(
                navController
            )
        }
        composable(ROUTE_MAIN_NAV.addCategory.name) {
            GetLayoutAddCategoriesScreen(navController)
        }
        composable(ROUTE_MAIN_NAV.listCategoryUpdate.name) {
            GetLayoutEditCategoriesScreen(navController)
        }
        composable(ROUTE_MAIN_NAV.listCategoryDelete.name) {
            GetLayoutDeleteCategoriesScreen(navController)
        }
        composable(ROUTE_MAIN_NAV.updateCategory.name) {
            GetLayoutUpdateCategoriesScreen(navController)
        }

        composable(ROUTE_MAIN_NAV.addMon.name) {
            GetLayoutAddMonScreen(navController)
        }
        composable(ROUTE_MAIN_NAV.updateMon.name) {
            GetLayoutUpdateMonScreen(navController)
        }
        composable(ROUTE_MAIN_NAV.listMonUpdate.name) {
            GetLayoutListMonUpdateScreen(navController)
        }
        composable(ROUTE_MAIN_NAV.listMonDelete.name) {
            GetLayoutListMonDelete(navController)
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingGetLayoutAppNavigation() {

}