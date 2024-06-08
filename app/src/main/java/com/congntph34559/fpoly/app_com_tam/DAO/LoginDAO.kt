package com.congntph34559.fpoly.app_com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.congntph34559.fpoly.app_com_tam.Model.LoginModel

import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDAO {

    @Query("Select * From users")
    fun getAll() : Flow<List<LoginModel>>

    @Insert
    suspend fun insertLogin(user: LoginModel)

    @Query("Select * From users Where userName = :userName and password = :pass")
    fun getUserByUsernamePass(userName: String, pass: String) : Flow<LoginModel>

    @Query("SELECT * FROM users WHERE userName = :userName LIMIT 1")
    fun getUserByUsername(userName: String): LoginModel?
    @Upsert
    suspend fun updateLogin(user: LoginModel)

    @Delete
    suspend fun deleteLogin(user: LoginModel)
}