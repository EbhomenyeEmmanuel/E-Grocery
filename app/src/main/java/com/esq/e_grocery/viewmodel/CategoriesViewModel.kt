package com.esq.e_grocery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.data.CategoriesRepository
import com.esq.e_grocery.domain.model.CategoriesItem

class CategoriesViewModel : ViewModel() {
    private val _data = MutableLiveData<List<CategoriesItem>>().apply {
        value = CategoriesRepository.dataForCategories
    }

    val categoriesRvData: LiveData<List<CategoriesItem>> = _data

}
