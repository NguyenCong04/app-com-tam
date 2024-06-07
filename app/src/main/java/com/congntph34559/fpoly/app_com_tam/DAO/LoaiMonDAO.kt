package com.congntph34559.fpoly.app_com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel

@Dao
interface LoaiMonDAO {
    @Query("SELECT * FROM LoaiMonModel")
    fun getAll(): List<LoaiMonModel>

    @Query("SELECT * FROM LoaiMonModel WHERE IdLoaiMon IN (:loaiMonInt)")
    fun loadAllByIds(loaiMonInt: IntArray): List<LoaiMonModel>

    @Insert
    fun insert(vararg loaiMon: LoaiMonModel)

    @Delete
    fun delete(loaiMon: LoaiMonModel)

    @Query("SELECT * FROM LoaiMonModel WHERE IdLoaiMon = :IdLoaiMon")
    fun getById(IdLoaiMon: Int): LoaiMonModel

    @Update
    fun update(loaiMon: LoaiMonModel)
}
