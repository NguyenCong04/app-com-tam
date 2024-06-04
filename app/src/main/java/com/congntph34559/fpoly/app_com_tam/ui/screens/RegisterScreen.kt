package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerWidthCompose

@Composable
fun GetLayoutRegisterScreen(navController: NavHostController) {
    var isShowHidePass by remember {
        mutableStateOf(false)
    }
    var password by remember {
        mutableStateOf("")
    }
    var repassword by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xff252121)
            )
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_max),
            contentDescription = null,
            modifier = Modifier.size(150.dp, 150.dp)
        )
        Text(
            text = "Đăng ký",
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
                value = "",
                onValueChange = {},
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
        SpacerHeightCompose(height = 10)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            ) {
                Text(
                    text = "Full name",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    color = Color.White,
                    fontWeight = FontWeight(600)
                )
                TextField(
                    value = "",
                    onValueChange = {},
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
                            text = "Enter your full name",
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
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Phone number",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    color = Color.White,
                    fontWeight = FontWeight(600)
                )
                TextField(
                    value = "",
                    onValueChange = {},
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
                            text = "Enter your phone",
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
        }
        SpacerHeightCompose(height = 10)
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
                onValueChange = {
                    password = it
                },
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
                trailingIcon = {
                    IconButton(
                        onClick = {
                            isShowHidePass = !isShowHidePass
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if (!isShowHidePass) R.drawable.show
                                else R.drawable.an
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                },
                visualTransformation = if (!isShowHidePass) PasswordVisualTransformation()
                else VisualTransformation.None,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Re-Password",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            TextField(
                value = repassword,
                onValueChange = {
                    repassword = it
                },
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
                        text = "Enter your re-password",
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.cairo_regular)),

                        )
                },
                shape = RoundedCornerShape(size = 8.dp),
                trailingIcon = {
                    IconButton(
                        onClick = { isShowHidePass = !isShowHidePass }
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if (!isShowHidePass) R
                                    .drawable.show else R.drawable.an
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                },
                visualTransformation = if (!isShowHidePass) PasswordVisualTransformation()
                else VisualTransformation.None,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                )
            )
        }

        SpacerHeightCompose(height = 30)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(170.dp)
                .height(45.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffFE724C)
            )
        ) {
            Text(text = "Đăng ký")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingGetLayoutRegisterScreen() {
    GetLayoutRegisterScreen(navController = rememberNavController())
}