package com.esq.e_grocery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.data.HomeRepository
import com.esq.e_grocery.domain.model.Item
import com.esq.e_grocery.domain.model.PopularMenuItem

class HomeViewModel : ViewModel() {
    private val _horizontalRvData = MutableLiveData<List<Item>>().apply {
        value = HomeRepository.homeHorizontalRvData
    }

    val horizontalCategoriesRvData: LiveData<List<Item>> = _horizontalRvData

    private val _menuData = MutableLiveData<List<PopularMenuItem>>().apply {
        value = HomeRepository.popularRvMenuData
    }

    val menuData: LiveData<List<PopularMenuItem>> = _menuData

}
