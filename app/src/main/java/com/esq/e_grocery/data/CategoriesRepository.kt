package com.esq.e_grocery.data

import com.esq.e_grocery.R
import com.esq.e_grocery.domain.model.CategoriesItem

class CategoriesRepository {

    companion object {
        val dataForCategories = listOf(
            CategoriesItem(R.drawable.onion, R.string.onion),
            CategoriesItem(R.drawable.categories1, R.string.fresh_banana),
            CategoriesItem(R.drawable.meat, R.string.meat),
            CategoriesItem(R.drawable.banana, R.string.chicken),
            CategoriesItem(R.drawable.carousel2, R.string.rice),
            CategoriesItem(R.drawable.categories5, R.string.fresh_banana),
            CategoriesItem(R.drawable.carousel4, R.string.fresh_banana),
            CategoriesItem(R.drawable.categories2, R.string.meat),
            CategoriesItem(R.drawable.categories3, R.string.chicken),
            CategoriesItem(R.drawable.meat, R.string.rice),
            CategoriesItem(R.drawable.banana, R.string.fresh_banana),
            CategoriesItem(R.drawable.categories6, R.string.chicken),
            CategoriesItem(R.drawable.meat, R.string.rice),
            CategoriesItem(R.drawable.categories7, R.string.fresh_banana)
        )
    }
}