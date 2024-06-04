package com.congntph34559.fpoly.app_com_tam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
data class Category(
    val id: Int,
    val name: String
)

@Composable
fun GetLayoutEditCategoriesScreen() {
    ScaffoldCompose(onClickBack = { /*TODO*/ }) {
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
                }
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    onEditClick: (Category) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(color = Color(0xFF2F2D2D), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = category.id.toString(),

            style = TextStyle(
                fontWeight = FontWeight.Bold,

                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                color = Color.White
            )
        )
        Text(text = category.name,   fontFamily = FontFamily(Font(R.font.cairo_regular)), color = Color.White)
        IconButton(
            onClick = { onEditClick(category) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "Edit",
                tint = Color.White,
                modifier = Modifier
                    .size(18.dp)
            )
        }
    }
}

@Composable
fun CategoryList(
    categories: List<Category>,
    onEditClick: (Category) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(1f),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                onEditClick = onEditClick
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutEditCategoriesScreen() {
    GetLayoutEditCategoriesScreen()
}