package com.congntph34559.fpoly.app_com_tam.ui.screens.dish

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.congntph34559.fpoly.app_com_tam.Model.MonAnModel
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE
import kotlinx.coroutines.launch
import java.io.File
import kotlin.math.log


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetLayoutUpdateMonScreen(
    navController: NavHostController,
    viewModel: MonAnViewModel,
    id: Int?
) {

    var monDTO: MonAnModel? = null

    if (id != null) {
        monDTO = viewModel.getById(id)
    }


    var isExpandedLoaiMon by remember {
        mutableStateOf(false)
    }
    var isExpandedGia by remember {
        mutableStateOf(false)
    }
    var valueGia by remember {
        mutableStateOf(monDTO?.giaMonAn?.toString() ?: "")
    }
    var valueMon by remember {
        mutableStateOf(monDTO?.tenLoai ?: "")
    }
    var tenMon by remember {
        mutableStateOf(monDTO?.tenMonAn ?: "")
    }
    var imageMon by remember {
        mutableStateOf(monDTO?.anhMonAn ?: "")
    }

    var listLoaiMon = listOf<String>(
        "Món chính",
        "Món phụ"
    )
    var listGia = listOf<String>(
        "15",
        "25",
        "40",
        "50",
    )
    val scope = rememberCoroutineScope()

    //Open Gallery
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var context = LocalContext.current
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }



    ScaffoldCompose(onClickBack = {
        navController.popBackStack()
    }) {

        Column(
            modifier = Modifier
                .background(
                    color = Color(0xff252121)
                )
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeightCompose(height = 20)
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
                    )
                    .selectable(
                        selected = true,
                        onClick = {
                            launcher.launch("image/*")
                        }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (bitmap == null && imageUri == null) {
                    val painter =
                        rememberImagePainter(data = File(imageMon))
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .width(145.dp)
                            .clip(
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentScale = ContentScale.Crop,
                    )
                } else {
                    imageUri?.let {
                        if (Build.VERSION.SDK_INT < 28) {
                            bitmap = MediaStore.Images.Media.getBitmap(
                                context
                                    .contentResolver, it
                            )
                        } else {
                            val source = ImageDecoder.createSource(
                                context
                                    .contentResolver, it
                            )
                            bitmap = ImageDecoder.decodeBitmap(source)
                        }
                        bitmap?.let { btm ->
                            Image(
                                bitmap = btm.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(145.dp)
                                    .height(145.dp)
                                    .clip(
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentScale = ContentScale.Crop,
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Loại Món",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    color = Color.White,

                    )
                ExposedDropdownMenuBox(
                    expanded = isExpandedLoaiMon,
                    onExpandedChange = {
                        isExpandedLoaiMon = !isExpandedLoaiMon
                    },
                ) {
                    TextField(
                        value = valueMon,
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
                                text = "Món chính",
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                                ),
                            )
                        },
                        shape = if (!isExpandedLoaiMon) RoundedCornerShape(
                            size = 8.dp
                        ) else
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
                        expanded = isExpandedLoaiMon,
                        onDismissRequest = { isExpandedLoaiMon = false },
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(0.92f),
                    ) {
                        listLoaiMon.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = item,
                                        fontFamily = FontFamily(Font(R.font.cairo_regular))
                                    )
                                },
                                onClick = {
                                    valueMon = item
                                    isExpandedLoaiMon = false
                                },
                            )
                        }
                    }
                }

            }
            SpacerHeightCompose(height = 10)
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
                    expanded = isExpandedGia,
                    onExpandedChange = { isExpandedGia = !isExpandedGia },
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
                                text = valueMon,
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                                ),
                            )
                        },
                        shape = if (!isExpandedGia) RoundedCornerShape(size = 8.dp) else
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
                        expanded = isExpandedGia,
                        onDismissRequest = { isExpandedGia = false },
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(0.92f),
                    ) {
                        listGia.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = item,
                                        fontFamily = FontFamily(Font(R.font.cairo_regular))
                                    )
                                },
                                onClick = {
                                    valueGia = item
                                    isExpandedGia = false
                                },
                            )
                        }

                    }
                }

            }
            SpacerHeightCompose(height = 10)
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
                    value = tenMon,
                    onValueChange = {
                        tenMon = it
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
            SpacerHeightCompose(height = 40)
            Button(
                onClick = {
                    var imagePath: String? = null
                    bitmap?.let { btm ->
                        imagePath = saveBitmapToInternalStorage(
                            context,
                            btm,
                            "product_${System.currentTimeMillis()}"
                        )

                    }
                    monDTO?.let {
                        it.tenMonAn = tenMon
                        it.tenLoai = valueMon
                        it.giaMonAn = valueGia.toInt()
                        it.anhMonAn = if (bitmap == null && imageUri == null)
                            imageMon else imagePath
                        viewModel.update(it)
                        navController.popBackStack()
                    }
                },
                modifier = Modifier
                    .width(170.dp)
                    .height(45.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffFE724C)
                )
            ) {
                Text(
                    text = "Lưu",
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontWeight = FontWeight(600)
                )
            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingUpdateMonScreen() {
//    GetLayoutUpdateMonScreen(navController = rememberNavController(), db = db)
}