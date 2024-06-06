package com.congntph34559.fpoly.app_com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.congntph34559.fpoly.app_com_tam.Model.OrderDetailModel

@Dao
interface OrderDetailDAO {
    @Query("SELECT * FROM OrderDetailModel")
    fun getAll(): List<OrderDetailModel>

    @Query("SELECT * FROM OrderDetailModel WHERE orderId = :orderId")
    fun getByOrderId(orderId: Int): List<OrderDetailModel>

    @Insert
    fun insert(vararg orderDetail: OrderDetailModel)

    @Update
    fun update(orderDetail: OrderDetailModel)

    @Delete
    fun delete(orderDetail: OrderDetailModel)
}