package com.congntph34559.fpoly.app_com_tam.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutHoiTroScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutHomeScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.dish.GetLayoutManagerMonScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutQuanLyCategoriesScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutQuanLyScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.GetLayoutThongKeScreen
import com.congntph34559.fpoly.app_com_tam.ui.screens.dishorder.YourViewModel

enum class ROUTE {
    home,
    thongke,
    quanly,
    detail_ql_loai_mon,
    detail_ql_mon,
    hoitro,
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetLayoutButtonTopBarNavigation(navHostController: NavHostController, db: AppDatabase) {
    var isSelected by rememberSaveable {
        mutableStateOf(ROUTE.home.name)
    }
    var navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cum tứm đim",
                        fontFamily = FontFamily(Font(R.font.cairo_regular)),
                        color = Color.White,
                        fontWeight = FontWeight(700),
                        fontSize = 17.sp,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.avatar),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp, 50.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff252121)
                ),
                actions = {
                    if (isSelected === ROUTE.home.name) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                tint = Color(0xffffc341)
                            )
                        }
                    } else {
                        @Suppress("UNUSED_EXPRESSION")
                        null
                    }

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xff312C2C),
            ) {
                NavigationBarItem(
                    selected = isSelected === ROUTE.home.name,
                    onClick = {
                        isSelected = ROUTE.home.name
                        navController.navigate(ROUTE.home.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Trang chủ",
                            fontFamily = FontFamily(Font(R.font.cairo_regular)),
                            fontSize = 15.sp,
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C),

                        ),

                    )
                NavigationBarItem(
                    selected = isSelected === ROUTE.thongke.name,
                    onClick = {
                        isSelected = ROUTE.thongke.name
                        navController.navigate(ROUTE.thongke.name) {
                            popUpTo(0)
                        }
                    },

                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.thong_ke),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Thống kê",
                            fontFamily = FontFamily(Font(R.font.cairo_regular)),
                            fontSize = 15.sp,
                        )

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C)
                    ),
                )
                NavigationBarItem(
                    selected = isSelected === ROUTE.quanly.name,
                    onClick = {
                        isSelected = ROUTE.quanly.name
                        navController.navigate(ROUTE.quanly.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.quan_ly),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Quản lý",
                            fontFamily = FontFamily(Font(R.font.cairo_regular)),
                            fontSize = 15.sp,
                        )

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C)
                    ),
                )
                NavigationBarItem(
                    selected = isSelected === ROUTE.hoitro.name,
                    onClick = {
                        isSelected = ROUTE.hoitro.name
                        navController.navigate(ROUTE.hoitro.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.hoi_tro),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Hỗ trợ",
                            fontFamily = FontFamily(Font(R.font.cairo_regular)),
                            fontSize = 15.sp,
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xffFFB703),
                        selectedTextColor = Color(0xffFFB703),
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        indicatorColor = Color(0xff312C2C)
                    ),
                )

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xff000000)
                )
                .padding(it)
        ) {
            SpacerHeightCompose(height = 1)
            NavHost(
                navController = navController,
                startDestination = isSelected
            ) {
                composable(ROUTE.home.name) {
                    GetLayoutHomeScreen(
                        navHostController, viewModel = YourViewModel(db)
                    )
                }
                composable(ROUTE.thongke.name) { GetLayoutThongKeScreen() }
                composable(ROUTE.quanly.name) {
                    GetLayoutQuanLyScreen(
                        navController
                    )
                }
                composable(ROUTE.detail_ql_loai_mon.name) {
                    GetLayoutQuanLyCategoriesScreen(navHostController)
                }
                composable(ROUTE.detail_ql_mon.name) {
                    GetLayoutManagerMonScreen(navHostController)
                }
                composable(ROUTE.hoitro.name) { GetLayoutHoiTroScreen() }
            }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingLayoutButtonTopBarNavigation() {
//    GetLayoutButtonTopBarNavigation(navHostController = rememberNavController(), db = db)
}