package com.esq.e_grocery.data

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.esq.e_grocery.R
import com.esq.e_grocery.databinding.HomePopularItemListBinding
import com.esq.e_grocery.domain.interfaces.IMainActivity
import com.esq.e_grocery.domain.model.PopularProducts

class HomePopularMenuAdapter(
    private val context: Context,
    private var items: List<PopularProducts>
    //val itemClick: (option: Int, item: PopularMenuItem) -> Unit
) : RecyclerView.Adapter<HomePopularMenuAdapter.ItemViewHolder>() {
    companion object {
        private val TAG = this::class.java.simpleName
    }

    fun refreshList(products: List<PopularProducts>) {
        items = emptyList()
        items = (products)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate<HomePopularItemListBinding>(
                LayoutInflater.from(context),
                R.layout.home_popular_item_list,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val product = (items[position])
        holder.bind(product, context)
    }

    class ItemViewHolder(private var binding: HomePopularItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: PopularProducts, context: Context) {
            binding.product = product
            binding.iMainActivity = context as IMainActivity
            binding.executePendingBindings()
        }
    }
}