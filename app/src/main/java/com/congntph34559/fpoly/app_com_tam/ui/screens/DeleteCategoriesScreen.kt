package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.ui.compose.DialogCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose

@Composable
fun GetLayoutDeleteCategoriesScreen(navController: NavHostController) {
    var context = LocalContext.current
    var db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "Loaimon"
    ).allowMainThreadQueries().build()
    var list_loaiMon by remember {
        mutableStateOf(db.loaiMonDAO().getAll())
    }
    var isShowDialog by remember {
        mutableStateOf(false)
    }
    var category by remember {
        mutableStateOf(LoaiMonModel(0,""))
    }
    if (isShowDialog) {
      DialogCompose(
          onConfirmation = {
              db.loaiMonDAO().delete(category)
              isShowDialog = false
              Toast.makeText(
                  context,
                  "Xóa loại món thành công",
                  Toast.LENGTH_SHORT
              ).show()
              list_loaiMon = db.loaiMonDAO().getAll()
          },
          onCloseDialog = { isShowDialog = false },
          titleDialog = "Thông báo !",
          mess = "Bạn có chắc chắn muốn xóa loại món không?"
      )
    }
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
                onEditClick = { category ->
                    // Handle edit click for the selected category
                    println("Editing category: $category")
                },
                onDeleteClick = { clickedCategory ->
                    // Handle edit click for the selected category
                    println("Deleting category: $clickedCategory")
                    isShowDialog = true
                    category.IdLoaiMon = clickedCategory.IdLoaiMon
                    category.tenLoaiMon = clickedCategory.tenLoaiMon
                },
                showEditIcon = false,
                showDeleteIcon = true

            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutDeleteCategoriesScreen() {
    GetLayoutDeleteCategoriesScreen(navController = rememberNavController())
}