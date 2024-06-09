package com.congntph34559.fpoly.app_com_tam.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//@Entity(foreignKeys = [ForeignKey(
//    entity = LoaiMonModel::class,
//    parentColumns = ["IdLoaiMon"],
//    childColumns = ["idLoaiMon"],
//    onDelete = ForeignKey.CASCADE
//)])
@Entity
data class MonAnModel(
    @PrimaryKey(autoGenerate = true) var IdMon: Int = 0,
    @ColumnInfo(name = "anhMonAn") var anhMonAn: String?,
    @ColumnInfo(name = "tenMonAn") var tenMonAn: String?,
    @ColumnInfo(name = "giaMonAn") var giaMonAn: Int?,
//    @ColumnInfo(name = "soLuongMonAn") var soLuongMonAn: Int?,
    @ColumnInfo(name = "tenLoai") var tenLoai: String? // Tham chiếu đến
// IdLoaiMon từ LoaiMonModel
)
