package com.esq.e_grocery.domain.interfaces

import com.esq.e_grocery.domain.model.PopularProducts

interface IMainActivity {
    fun inflateViewProductFragment(item : PopularProducts)
}