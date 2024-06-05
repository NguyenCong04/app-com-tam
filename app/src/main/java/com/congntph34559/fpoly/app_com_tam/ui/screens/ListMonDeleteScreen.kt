package com.congntph34559.fpoly.app_com_tam.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.congntph34559.fpoly.app_com_tam.ui.compose.DialogCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose

@Composable
fun GetLayoutListMonDelete() {
    var content = LocalContext.current
    var isShowDialog by remember {
        mutableStateOf(false)
    }
    if (isShowDialog) {
        DialogCompose(
            onConfirmation = { /*TODO*/ },
            onCloseDialog = { isShowDialog = false },
            titleDialog = "Thông báo",
            mess = "Bạn có chắc chắn muốn xóa món không ?"
        )
    }

    ScaffoldCompose(onClickBack = {
        isShowDialog = true
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xff252121)
                )
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(listMon) {
                    PostItemMon(
                        iconDelete = true,
                        iconUpdate = false,
                        monDTO = it,
                        onClickIconDelete = {
                            isShowDialog = true
                        },
                        onClickIconUpdate = null
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingLayoutListMonDeleteScreen() {
    GetLayoutListMonDelete()
}