package com.congntph34559.fpoly.app_com_tam.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.congntph34559.fpoly.app_com_tam.DAO.LoginDAO
import com.congntph34559.fpoly.app_com_tam.Model.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel(private val dao: LoginDAO) : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _isAuthenticated = MutableLiveData<Boolean?>()
    val isAuthenticated: LiveData<Boolean?> = _isAuthenticated

    private val _isShowPassword = MutableLiveData<Boolean>()
    val isShowPassword: LiveData<Boolean> = _isShowPassword


    private val _isRole = MutableLiveData<Int>()
    val isRole: LiveData<Int> = _isRole

    fun insertSampleAdminIfNeeded () {

        viewModelScope.launch {
            var users : List<LoginModel> = listOf()
            dao.getAll().collect{
                users = it
                if (users.isEmpty()) {
                    dao.insertLogin(LoginModel(userName = "cong1", password = "123", "cong1@gmail.com",0))
                    dao.insertLogin(LoginModel(userName = "tam2", password = "456", "tam2@gmail.com",0))
                }
            }
        }
    }



    fun login(username: String, password: String) {

        viewModelScope.launch {

            val user = dao.getUserByUsernamePass(username, password)
            user.collect{
                if (it != null) {
                    _isAuthenticated.value = true
                    _isRole.value = it.role

                } else {
                    _isAuthenticated.value = false
                }
            }
        }
//        if (username.equals("admin") && password.equals("123")) {
//            _isAuthenticated.value = true
//        } else {
//            _isAuthenticated.value = false
//        }
    }

    fun resetAuthenticationState() {
        _isAuthenticated.value = null
    }

}