package com.esq.e_grocery.viewmodel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.data.HomeRepository
import com.esq.e_grocery.domain.interfaces.SearchQueryResultCallback
import com.esq.e_grocery.domain.model.Item
import com.esq.e_grocery.domain.model.PopularProducts
import com.esq.e_grocery.domain.model.SearchForProductsDataModel

class HomeViewModel(
    private val searchQueryResultCallback: SearchQueryResultCallback
) : ViewModel() {
    private val _horizontalRvData = MutableLiveData<List<Item>>().apply {
        value = HomeRepository.homeHorizontalRvData
    }

    val horizontalCategoriesRvData: LiveData<List<Item>> = _horizontalRvData

    private val _menuData = MutableLiveData<List<PopularProducts>>().apply {
        value = HomeRepository.popularRvMenuData
    }

    val mMenuData: LiveData<List<PopularProducts>> = _menuData

    private var mSearchQueryDataModel: SearchForProductsDataModel = SearchForProductsDataModel("")

    var isNewlyCreated = true
    var searchQueryName: String = "com.esq.e_grocery.viewmodel.searchQueryName"
    var searchKey: String = mSearchQueryDataModel.searchValue

    companion object {
        val TAG = this::class.java.simpleName
    }

    //Write method to get search query from editText and set to searchQueryModel
    fun getSearchQueryTextWatcher(): TextWatcher? {
        Log.d(TAG, "TextWatcher is listening")
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                mSearchQueryDataModel.searchValue = (editable.toString().trim { it <= ' ' })
            }
        }
    }

    //Write method to process Editor Click
    fun onQueryListener(): TextView.OnEditorActionListener? {
        Log.d(TAG, "Editor is clicked")
        return TextView.OnEditorActionListener { p0, p1, p2 ->
            if (p1 == EditorInfo.IME_ACTION_SEARCH) {
                val errorCode: Int = mSearchQueryDataModel.isValidData()
                if (errorCode == 1) {
                    searchQueryResultCallback.onFailedQuery("Query is empty!!!")
                } else if (errorCode == 0) {
                    //Query has been validated
                    searchQueryResultCallback.onSuccessfulQuery(mSearchQueryDataModel.searchValue)
                }
                true
            } else
                false
        }
    }

    fun saveState(outState: Bundle) {
        outState.putString(searchQueryName, searchKey)
    }

    fun restoreState(savedInstanceState: Bundle) {
        searchKey = savedInstanceState.getString(searchQueryName).toString()
    }
}
