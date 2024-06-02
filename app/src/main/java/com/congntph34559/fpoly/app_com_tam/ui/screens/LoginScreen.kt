package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.GetLayoutButtonTopBarNavigation
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV

@Composable
fun GetLayoutLoginScreen(navController: NavHostController) {
    var context = LocalContext.current
    ScaffoldCompose(onClickBack = {
        Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
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
            Text(
            text = "Đăng Nhập",
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif
        )
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
            Text(
                text = "Nhập User Name",
                color = Color.White,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, end = 26.dp)
                    .align(Alignment.Start)
            )
            var userName by remember { mutableStateOf("") }

            // TextField for input
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Nhập User Name") },
                modifier = Modifier
                    . fillMaxWidth(fraction = 1f)
                    .padding(start = 26.dp, end = 26.dp)
                    .height(65.dp)
            )
            Text(
                text = "Nhập Pass Word",
                color = Color.White,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 26.dp, end = 26.dp)
                    .align(Alignment.Start)
            )
            var passWord by remember { mutableStateOf("") }

            // TextField for input
            OutlinedTextField(
                value = passWord,
                onValueChange = { passWord = it },
                label = { Text("Nhập Pass Word") },
                modifier = Modifier
                    . fillMaxWidth(fraction = 1f)
                    .padding(start = 26.dp, end = 26.dp)
                    .height(65.dp)
            )

                Text(
                    text = "Forgot Password",
                    fontFamily = FontFamily.Serif,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xffffffff),
                    modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
                )
                Button(
                    onClick = {
                        navController.navigate("home")
                    },
                    modifier = Modifier.size(290.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffffffff)
                    ),
                    shape = RoundedCornerShape(8.dp)

                ) {
                    Text(
                        text = "Log in",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(600),
                        color = Color(0xff000000),
                    )
                }
                Text(
                    text = "SIGN UP",
                    modifier = Modifier.padding(top = 20.dp).selectable(
                        selected = true,
                        onClick = {
                            navController.navigate("signup")
                        }
                    ),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xffffffff)
                )


                   }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutLogin() {
    GetLayoutLoginScreen(navController = rememberNavController())
}