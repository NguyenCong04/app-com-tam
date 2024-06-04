package com.congntph34559.fpoly.app_com_tam.ui.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerWidthCompose(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}