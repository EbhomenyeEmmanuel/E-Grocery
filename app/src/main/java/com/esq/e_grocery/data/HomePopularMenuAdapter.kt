package com.esq.e_grocery.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esq.e_grocery.R
import com.esq.e_grocery.domain.model.PopularMenuItem
import kotlinx.android.synthetic.main.popular_menu_item_list.view.*

class HomePopularMenuAdapter(
    private val context: Context,
    private val items: List<PopularMenuItem>,
    val itemClick: (option: Int, item: PopularMenuItem) -> Unit
) : RecyclerView.Adapter<HomePopularMenuAdapter.ItemViewHolder>() {
    companion object {
        private val TAG = this::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.popular_menu_item_list,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.ibSingleAddItem.setOnClickListener {
            itemClick(1, items[position])
        }
        holder.itemView.ibAddItem.setOnClickListener {
            itemClick(2, items[position])
        }
        holder.itemView.ibSubtractItem.setOnClickListener {
            itemClick(3, items[position])
        }
    }

    inner class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(item: PopularMenuItem) {
            Log.d(TAG, "Popular Items is $item")
            with(item) {
                view.ivfoodIcon.setImageDrawable(context.getDrawable(item.menuIcon))
                view.tvfoodName.text = context.getString(foodName)
                view.tvFoodWeight.text = "Net wt ${foodWeight}kg"
                view.tvFoodPrice.text = "₦${foodPrice}"
            }
        }
    }
}