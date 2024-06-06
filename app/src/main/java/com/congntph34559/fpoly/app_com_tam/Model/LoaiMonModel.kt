package com.congntph34559.fpoly.app_com_tam.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoaiMonModel(
    @PrimaryKey(autoGenerate = true) var IdLoaiMon: Int=0,
    @ColumnInfo(name = "tenLoaiMon") var tenLoaiMon: String?,
)