package com.esq.e_grocery.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esq.e_grocery.data.HomePopularMenuAdapter
import com.esq.e_grocery.domain.model.PopularProducts

class HomeFragmentBindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("popularItemList")
        fun setPopularList(view: RecyclerView, list: List<PopularProducts>?) {
            if (list == null)
                return
            val layoutManager: RecyclerView.LayoutManager? = view.layoutManager
            if (layoutManager == null) {
                view.layoutManager = LinearLayoutManager(view.context)
                // view.layoutManager.orientation = LinearLayoutManager.VERTICAL
            }
            view.adapter = view.adapter as HomePopularMenuAdapter??: HomePopularMenuAdapter(view.context, list)
        }
    }
}