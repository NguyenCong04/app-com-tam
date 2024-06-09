package com.congntph34559.fpoly.app_com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.congntph34559.fpoly.app_com_tam.Model.MonAnModel
@Dao
interface MonAnDAO {
    @Query("SELECT * FROM MonAnModel")
    fun getAll(): List<MonAnModel>

//    @Transaction
//    @Query("SELECT * FROM MonAnModel")
//    fun getMonAnWithLoaiMon(): List<MonAnWithLoaiMon>

    @Query("SELECT * FROM MonAnModel WHERE IdMon = :idMon")
    fun getById(idMon: Int): MonAnModel

    @Insert
    fun insert(vararg monAn: MonAnModel)

    @Update
    fun update(monAn: MonAnModel)


    @Delete
    fun delete(monAn: MonAnModel)
}
