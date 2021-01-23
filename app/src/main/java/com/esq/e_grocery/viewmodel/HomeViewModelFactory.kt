package com.esq.e_grocery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esq.e_grocery.domain.interfaces.SearchQueryResultCallback

class HomeViewModelFactory(private val searchQueryResultCallback: SearchQueryResultCallback) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(
                searchQueryResultCallback
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}