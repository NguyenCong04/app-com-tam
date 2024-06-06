package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose

@Composable
fun GetLayoutDeleteCategoriesScreen(navController: NavHostController) {
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
            val categories = listOf(
                Category(1, "Electronics"),
                Category(2, "Clothing"),
                Category(3, "Books")
            )
            CategoryList(
                categories = categories,
                onEditClick = { category ->
                    // Handle edit click for the selected category
                    println("Editing category: $category")
                },
                onDeleteClick = { category ->
                    // Handle edit click for the selected category
                    println("Editing category: $category")
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