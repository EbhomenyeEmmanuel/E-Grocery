package com.esq.e_grocery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.data.FavouriteRepository
import com.esq.e_grocery.domain.model.Item

class FavouritesViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Item>>().apply {
        value = FavouriteRepository.dataForFavourite
    }

    val favouritesRvData: LiveData<List<Item>> = _data

}
