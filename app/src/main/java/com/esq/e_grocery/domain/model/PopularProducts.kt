package com.esq.e_grocery.domain.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@SuppressLint("ParcelCreator")
data class PopularProducts(
    val menuIcon: Int, val foodName: Int, val foodWeight: Int, val foodPrice: Int
) :Parcelable{
    var id: String? = null
        set(value) {
            field = value
        }
        get() {
            return field
        }
}
