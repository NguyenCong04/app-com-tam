package com.congntph34559.fpoly.app_com_tam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import androidx.navigation.navArgument
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutAddCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.dish.GetLayoutAddMonScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutDeleteCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutDetailDonHang
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutEditCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.dish.GetLayoutListMonDelete
import com.congntph34559.fpoly.app_com_tam.ui.screens.dish.GetLayoutListMonUpdateScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutLoginScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutRegisterScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutUpdateCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.dish.GetLayoutUpdateMonScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.welcome.GetLayoutWelcome

enum class ROUTE_MAIN_NAV {
    welcome,
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
        startDestination = ROUTE_MAIN_NAV.welcome.name
    ) {
        composable(ROUTE_MAIN_NAV.welcome.name) {
            GetLayoutWelcome(
                navController
            )
        }
        composable(ROUTE_MAIN_NAV.login.name) {
            val context = LocalContext.current
            val loginDAO = Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build().LoginDAO()
            GetLayoutLoginScreen(navController = navController, loginDAO = loginDAO)
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
        composable(

            "${  ROUTE_MAIN_NAV.updateCategory.name }/{IdLoaiMon}",
                arguments = listOf(
                navArgument(name = "IdLoaiMon") {
                    type = NavType.IntType
                }
                )
        )
        {backStackEntry->
            GetLayoutUpdateCategoriesScreen(
                navController,
                backStackEntry.arguments?.getInt("IdLoaiMon",0)
            )
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