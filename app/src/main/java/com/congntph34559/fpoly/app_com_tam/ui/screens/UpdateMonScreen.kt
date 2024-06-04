package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetLayoutUpdateMonScreen() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var valueGia by remember {
        mutableStateOf("5 - 15")
    }



    ScaffoldCompose(onClickBack = { /*TODO*/ }) {

        Column(
            modifier = Modifier
                .background(
                    color = Color(0xff252121)
                )
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeightCompose(height = 40)

            Column(
                modifier = Modifier
                    .size(150.dp, 150.dp)
                    .background(
                        color = Color(0xffD9DCDF),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .dashedBorder(
                        strokeWidth = 2.dp,
                        color = Color(0xff4E4B66),
                        cornerRadius = 8.dp,
                        dashLength = 8.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_demo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(145.dp)
                        .clip(
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentScale = ContentScale.Crop,

                    )

            }
            SpacerHeightCompose(height = 50)
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Tên món ăn",
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
                            text = "Nhập tên món",
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
            SpacerHeightCompose(height = 20)
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Giá",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    color = Color.White,

                    )
                ExposedDropdownMenuBox(
                    expanded = isExpanded,
                    onExpandedChange = { isExpanded = !isExpanded },
                ) {
                    TextField(
                        value = "${valueGia}k",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(1f),
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
                                text = valueGia,
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                                ),
                            )
                        },
                        shape = if (!isExpanded) RoundedCornerShape(size = 8.dp) else
                            RoundedCornerShape(
                                topEnd = 8.dp, topStart = 8.dp,
                                bottomEnd = 0.dp, bottomStart = 0.dp
                            ),
                        textStyle = TextStyle(
                            fontFamily = FontFamily(Font(R.font.cairo_regular))
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    )
                    DropdownMenu(
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded = false },
                        modifier = Modifier.width(363.dp)
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "5 - 15",
                                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                                )
                            },
                            onClick = {
                                valueGia = "5 - 15"
                                isExpanded = false
                            },
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "15 - 30",
                                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                                )
                            },
                            onClick = {
                                valueGia = "15 - 30"
                                isExpanded = false
                            },
                        )


                    }
                }

            }
            SpacerHeightCompose(height = 50)
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
                Text(text = "Lưu")
            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingUpdateMonScreen() {
    GetLayoutUpdateMonScreen()
}