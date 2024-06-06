package com.congntph34559.fpoly.app_com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.congntph34559.fpoly.app_com_tam.Model.OrderModel
import com.congntph34559.fpoly.app_com_tam.Model.OrderDetailModel

@Dao
interface OrderDAO {
    @Query("SELECT * FROM OrderModel")
    fun getAll(): List<OrderModel>

    @Query("SELECT * FROM OrderModel WHERE IdOrder = :idOrder")
    fun getById(idOrder: Int): OrderModel

    @Insert
    fun insert(vararg order: OrderModel)

    @Update
    fun update(order: OrderModel)

    @Delete
    fun delete(order: OrderModel)
}
