package com.congntph34559.fpoly.app_com_tam.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.Model.OrderModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDAO {
    @Query("SELECT * FROM OrderModel")
    fun getAll() : List<OrderModel>

    @Update
    suspend fun updateOrderStatus(order: OrderModel)

    @Insert
    fun insertOrder(vararg order: OrderModel)
    @Query("SELECT * FROM OrderModel WHERE IdOrder= :IdOrder")
    fun getById(IdOrder: Int): OrderModel

    @Query("UPDATE OrderModel SET status = :newStatus WHERE IdOrder = :orderId")
    suspend fun updateOrderStatusById(orderId: Int, newStatus: Boolean)

}
