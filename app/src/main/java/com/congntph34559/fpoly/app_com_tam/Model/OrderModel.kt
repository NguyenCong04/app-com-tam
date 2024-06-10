package com.congntph34559.fpoly.app_com_tam.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderModel(
    @PrimaryKey(autoGenerate = true) var IdOrder: Int=0,
    @ColumnInfo(name = "tenDonhang") var tenDonhang: String?,
    @ColumnInfo(name = "price") var price: Float?,
    @ColumnInfo(name = "status") var status: Boolean = false
    )