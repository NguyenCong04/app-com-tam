package com.congntph34559.fpoly.app_com_tam.DBHelper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.congntph34559.fpoly.app_com_tam.DAO.MonAnDAO
import com.congntph34559.fpoly.app_com_tam.DAO.LoaiMonDAO
import com.congntph34559.fpoly.app_com_tam.DAO.LoginDAO
import com.congntph34559.fpoly.app_com_tam.Model.MonAnModel
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.Model.LoginModel
import com.congntph34559.fpoly.app_com_tam.Model.OrderModel
import com.congntph34559.fpoly.app_com_tam.DAO.OrderDAO


@Database(entities = [MonAnModel::class, LoaiMonModel::class,OrderModel::class, LoginModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun monAnDAO(): MonAnDAO
    abstract fun loaiMonDAO(): LoaiMonDAO
    abstract fun OrderDAO(): OrderDAO
    abstract fun LoginDAO(): LoginDAO
}