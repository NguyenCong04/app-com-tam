package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV



@Composable
fun GetLayoutEditCategoriesScreen(navController: NavHostController, db: AppDatabase) {
    var context = LocalContext.current

    var list_loaiMon by remember {
        mutableStateOf(db.loaiMonDAO().getAll())
    }
//    var category by remember {
//        mutableStateOf(LoaiMonModel(0,""))
//    }
    ScaffoldCompose(onClickBack = {
        navController.popBackStack()
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff252121)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            val categories = list_loaiMon
            CategoryList(
                categories = categories,
                onDeleteClick = { category ->
                    // Handle delete click for the selected category
                    println("Deleting category: $category")

                },
                onEditClick = { category ->

                    println("Editing category: $category")
                  navController.navigate("${  ROUTE_MAIN_NAV.updateCategory.name }/${category.IdLoaiMon}"
                    )
                },
                showEditIcon = true,
                showDeleteIcon = false
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: LoaiMonModel,
    onEditClick: (LoaiMonModel) -> Unit,
    onDeleteClick: (LoaiMonModel) -> Unit,
    showDeleteIcon: Boolean,
    showEditIcon: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(
                color = Color(0xFF2F2D2D),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = category.IdLoaiMon.toString(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color.White
            )
        )
        Text(
            text = category.tenLoaiMon ?: "Unknown",
            fontFamily = FontFamily(Font(R.font.cairo_regular)),
            color = Color.White
        )
        if (showEditIcon) {
            IconButton(
                onClick = { onEditClick(category) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Edit",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

        }
        if (showDeleteIcon) {
            IconButton(
                onClick = { onDeleteClick(category) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "Delete",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryList(
    categories: List<LoaiMonModel>,
    onEditClick: (LoaiMonModel) -> Unit,
    onDeleteClick: (LoaiMonModel) -> Unit,
    showDeleteIcon: Boolean,
    showEditIcon: Boolean
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(1f),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                onEditClick = onEditClick,
                onDeleteClick = onDeleteClick,
                showDeleteIcon = showDeleteIcon,
                showEditIcon = showEditIcon
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutEditCategoriesScreen() {
  //  GetLayoutEditCategoriesScreen(navController = rememberNavController(), db = db)
}
