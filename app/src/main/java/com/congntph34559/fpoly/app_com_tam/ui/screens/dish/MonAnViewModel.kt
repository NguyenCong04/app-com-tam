package com.congntph34559.fpoly.app_com_tam.ui.screens.dish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.LoaiMonModel
import com.congntph34559.fpoly.app_com_tam.Model.MonAnModel
import kotlinx.coroutines.launch

class MonAnViewModel(
    private val db: AppDatabase
) : ViewModel() {

    fun addMon(monAnModel: MonAnModel) {

        viewModelScope.launch {
            db.monAnDAO().insert(
                monAnModel
            )
        }

    }

    fun getById(id: Int): MonAnModel? {
        var model: MonAnModel? = null
        viewModelScope.launch {
            model = db.monAnDAO().getById(id)
        }
        return model
    }

    fun update(monAnModel: MonAnModel) {
        viewModelScope.launch {
            db.monAnDAO().update(
                monAnModel
            )
        }
    }

    fun getListLoaiMon(): List<LoaiMonModel>? {
        var list:List<LoaiMonModel>? = null
        viewModelScope.launch {
            list = db.loaiMonDAO().getAll()
        }
        return list
    }


}