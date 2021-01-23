package com.esq.e_grocery.domain.model

import android.text.TextUtils

//Model class for an search query object
class SearchForProductsDataModel(var searchValue: String) {
    fun isValidData(): Int {
        return if (TextUtils.isEmpty(searchValue)) {
            1
        } else {
            return 0
        }
    }

}