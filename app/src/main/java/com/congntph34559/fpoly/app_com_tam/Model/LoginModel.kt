package com.congntph34559.fpoly.app_com_tam.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class LoginModel(
    var userName: String,
    var password: String,
    var email: String,
    var role: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)