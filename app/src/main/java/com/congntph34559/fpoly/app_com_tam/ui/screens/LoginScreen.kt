package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.congntph34559.fpoly.app_com_tam.DAO.LoginDAO
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.LoginViewModel
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerWidthCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.GetLayoutButtonTopBarNavigation
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV
import com.google.android.libraries.mapsplatform.transportation.consumer.model.Route


@Composable
fun GetLayoutLoginScreen(navController: NavHostController, loginDAO: LoginDAO) {

    val loginViewModel = LoginViewModel(loginDAO)
    loginViewModel.insertSampleAdminIfNeeded()

    val isAuthenticated by loginViewModel.isAuthenticated.observeAsState()
    val role by loginViewModel.isRole.observeAsState()

    val context = LocalContext.current
    LaunchedEffect(key1 = isAuthenticated) { when (isAuthenticated) {
        true -> {
            Log.d("zzzzzzz", "login: $role")
            if (role == 0){
                navController.navigate(ROUTE_MAIN_NAV.home.name) {
                    popUpTo(ROUTE_MAIN_NAV.login.name) { inclusive = true } }
            }else{
                navController.navigate(ROUTE_MAIN_NAV.welcome.name) {
                    popUpTo(ROUTE_MAIN_NAV.login.name) { inclusive = true } }
            }

        }
        false -> {
            Toast.makeText(context, "Invalid username or password.", Toast.LENGTH_SHORT).show()
            loginViewModel.resetAuthenticationState() }
        null -> {} }
    }

    val usernameState by loginViewModel.username.observeAsState("")
    val isShowPasswordState by loginViewModel.isShowPassword.observeAsState(false)

    var username by remember { mutableStateOf(usernameState) }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(isShowPasswordState) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xff252121)
            )
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_max),
            contentDescription = null,
            modifier = Modifier.size(150.dp, 150.dp)
        )
        Text(
            text = "Đăng Nhập",
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.cairo_bold)),
            color = Color.White
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Email",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            TextField(
                value = username,
                onValueChange = { username = it },
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
                        text = "Enter your email",
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
        SpacerHeightCompose(height = 15)
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Password",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
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
                        text = "Enter your password",
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

        SpacerHeightCompose(height = 30)
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .width(170.dp)
                .height(45.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffFE724C)
            )
        ) {
            Text(text = "Đăng Nhập")
        }
        SpacerHeightCompose(height = 10)
        Row {
            Text(
                text = "Bạn chưa có tài khoản",
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color.White
            )
            SpacerWidthCompose(width = 5)
            Text(
                text = "Đăng Ký",
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color(0xffFE724C),
                modifier = Modifier
                    .clickable {
                        // Hành động khi người dùng nhấp vào nút
                        // Ví dụ: chuyển đến trang đăng ký
                        navController.navigate("register")
                    }
            )

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutLogin() {
    val context = LocalContext.current
    val loginDAO = Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build().LoginDAO()
    GetLayoutLoginScreen(navController = rememberNavController(), loginDAO = loginDAO)
}

