@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.congntph34559.fpoly.app_com_tam.ui.screens.dish

import android.net.Uri
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.MonAnModel
import com.congntph34559.fpoly.app_com_tam.R
import com.congntph34559.fpoly.app_com_tam.ui.compose.ScaffoldCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerHeightCompose
import com.congntph34559.fpoly.app_com_tam.ui.compose.SpacerWidthCompose
import com.congntph34559.fpoly.app_com_tam.ui.navigation.ROUTE_MAIN_NAV
import java.io.File


@Composable
fun GetLayoutListMonUpdateScreen(
    navController: NavHostController,
    db: AppDatabase
) {
    var content = LocalContext.current
    val monAnDAO = db.monAnDAO()
    var listMon by remember {
        mutableStateOf(monAnDAO.getAll())
    }
    ScaffoldCompose(onClickBack = {
        navController.popBackStack()
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
                    .padding(10.dp)
            ) {
                items(listMon) {
                    PostItemMon(
                        iconDelete = false,
                        iconUpdate = true,
                        it,
                        onClickIconUpdate = {
                            navController.navigate(
                                "${
                                    ROUTE_MAIN_NAV.updateMon.name
                                }/${it.IdMon}"
                            )
                        }, onClickIconDelete = null
                    )
                }
            }

        }
    }
}

@Composable
fun PostItemMon(
    iconDelete: Boolean,
    iconUpdate: Boolean,
    monDTO: MonAnModel,
    onClickIconUpdate: (() -> Unit)?,
    onClickIconDelete: (() -> Unit)?
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color(0xff2F2D2D),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = monDTO.IdMon.toString(),
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.cairo_regular))
                )
                SpacerWidthCompose(width = 15)
//                val painter = rememberImagePainter(data = Uri.parse(monDTO.anhMonAn))
                val painter =
                    rememberImagePainter(data = File(monDTO.anhMonAn.toString()))
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(
                            shape =
                            RoundedCornerShape(15.dp)
                        )
                )
                SpacerWidthCompose(width = 20)
                Column() {
                    Text(
                        text = monDTO.tenMonAn.toString(),
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.cairo_regular))
                    )
                    Text(
                        text = "${monDTO.giaMonAn}K",
                        color = Color(0xffFE724C),
                        fontFamily = FontFamily(Font(R.font.cairo_regular))
                    )
                }
            }
            IconButton(
                onClick =
                (if (iconUpdate === true) onClickIconUpdate else onClickIconDelete)!!,
                modifier = Modifier.weight(0.3f)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (iconUpdate === true) R.drawable.edit_mon
                        else R.drawable.delete_mon
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color.White
                )
            }

        }

    }
    SpacerHeightCompose(height = 20)

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingGetLayoutListMonUpdateScreen() {
//    GetLayoutListMonUpdateScreen(
//        navController = rememberNavController(),
//
//    )
}