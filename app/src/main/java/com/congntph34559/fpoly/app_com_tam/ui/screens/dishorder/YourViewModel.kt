package com.congntph34559.fpoly.app_com_tam.ui.screens.dishorder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.congntph34559.fpoly.app_com_tam.DBHelper.AppDatabase
import com.congntph34559.fpoly.app_com_tam.Model.OrderModel
import kotlinx.coroutines.launch

class YourViewModel(private val db: AppDatabase) : ViewModel() {

    fun insertOrder(order:OrderModel) {
        viewModelScope.launch {
            db.OrderDAO().insertOrder(order)
        }
    }


    fun getAll(): List<OrderModel>? {
        var list: List<OrderModel>? = null
        viewModelScope.launch {
            list = db.OrderDAO().getAll()
        }
        return list
    }

    fun updateOrder(order: OrderModel) {
        viewModelScope.launch {
            db.OrderDAO().updateOrderStatus(order)
        }
    }


   fun getById(id:Int):OrderModel? {
       var modell: OrderModel?=null
       viewModelScope.launch {
           modell=db.OrderDAO().getById(id)
       }
       return modell
   }
//
//    fun getAll(): LiveData<List<OrderModel>> = dao.getAll().asLiveData()
//
//    fun updateOrderStatusById(orderId: Int, newStatus: Boolean) {
//        viewModelScope.launch {
//            dao.updateOrderStatusById(orderId, newStatus)
//        }
//    }


}
