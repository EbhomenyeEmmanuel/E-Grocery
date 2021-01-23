package com.esq.e_grocery.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.domain.model.PopularProducts
import com.esq.e_grocery.utils.Constants

/**
 * [ViewModel] class for everything concerning a product being viewed.
 */
class ViewProductViewModel : ViewModel() {
    val TAG = this::class.java.simpleName
    var isNewlyCreated = true

    var mItem: PopularProducts? = null
    private var nameOfBundlePassed = Constants.NAME_OF_BUNDLE_SAVED_TO_VIEW_MODEL

    fun saveState(outState: Bundle) {
        Log.d(TAG, "item about to be saved is $mItem")
        outState.putParcelable(nameOfBundlePassed, mItem)
    }

    fun restoreState(savedInstanceState: Bundle) {
        Log.d(TAG, "item restored from viewMOdel is $mItem")
        mItem = savedInstanceState.getParcelable(nameOfBundlePassed)!!
    }

}
