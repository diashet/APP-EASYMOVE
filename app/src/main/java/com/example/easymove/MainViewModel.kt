package com.example.easymove

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val service = EmpresasDAO()
    private val _items = MutableLiveData<List<Empresas>>()

    val items: LiveData<List<Empresas>>
    get() = _items

    fun fetchEmpresas() {
        viewModelScope.launch(Dispatchers.IO){
            val res = service.getEmpresasDAO()

            if (res.isSuccessful){
                withContext(Dispatchers.Main){
                    _items.value = res.body()
                }
            }
        }
    }
}