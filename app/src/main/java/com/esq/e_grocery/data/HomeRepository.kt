package com.esq.e_grocery.data

import com.esq.e_grocery.R
import com.esq.e_grocery.domain.model.Item
import com.esq.e_grocery.domain.model.PopularProducts

class HomeRepository {

    companion object {
        val homeHorizontalRvData = listOf(
            Item(R.drawable.categories7),
            Item(R.drawable.carousel2),
            Item(R.drawable.categories2),
            Item(R.drawable.carousel4),
            Item(R.drawable.onion),
            Item(R.drawable.categories1),
            Item(R.drawable.carousel2),
            Item(R.drawable.categories3)
        )
        val popularRvMenuData = listOf(
            PopularProducts(R.drawable.onion, R.string.onion, 1, 100),
            PopularProducts(R.drawable.banana, R.string.fresh_banana, 2, 120),
            PopularProducts(R.drawable.meat, R.string.meat, 3, 160),
            PopularProducts(R.drawable.banana,R.string.chicken, 6, 140),
            PopularProducts(R.drawable.meat, R.string.rice, 4, 150),
            PopularProducts(R.drawable.banana, R.string.fresh_banana, 3, 160),
            PopularProducts(R.drawable.meat, R.string.meat, 6, 140)
        )
    }
}