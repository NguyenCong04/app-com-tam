package com.congntph34559.fpoly.app_com_tam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.congntph34559.fpoly.app_com_tam.DAO.LoginDAO
import com.congntph34559.fpoly.app_com_tam.ui.LoginViewModel

class LoginViewModelFactory(private val dao: LoginDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
