package com.congntph34559.fpoly.app_com_tam.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = OrderModel::class,
            parentColumns = ["IdOrder"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrderDetailModel(
    @PrimaryKey(autoGenerate = true) var IdOrderDetail: Int = 0,
    @ColumnInfo(name = "orderId") var orderId: Int,
    @ColumnInfo(name = "orderName") var orderName: String?,
    @ColumnInfo(name = "orderStatus") var orderStatus: String?,
    @ColumnInfo(name = "totalAmount") var totalAmount: Double?,
    @ColumnInfo(name = "monAnId") var monAnId: Int,
    @ColumnInfo(name = "price") var price: Double
)
