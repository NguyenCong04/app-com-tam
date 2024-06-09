package com.congntph34559.fpoly.app_com_tam.DBHelper

import androidx.room.Database
import androidx.room.RoomDatabase
import com.congntph34559.fpoly.app_com_tam.DAO.MonAnDAO
import com.congntph34559.fpoly.app_com_tam.DAO.LoaiMonDAO
import com.congntph34559.fpoly.app_com_tam.DAO.LoginDAO
import com.congntph34559.fpoly.app_com_tam.Model.MonAnModel
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.Model.LoginModel

@Database(entities = [MonAnModel::class, LoaiMonModel::class, LoginModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun monAnDAO(): MonAnDAO
    abstract fun loaiMonDAO(): LoaiMonDAO
    abstract fun LoginDAO(): LoginDAO
}