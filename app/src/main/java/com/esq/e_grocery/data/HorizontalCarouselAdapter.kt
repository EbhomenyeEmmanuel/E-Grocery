package com.esq.e_grocery.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esq.e_grocery.R
import com.esq.e_grocery.domain.model.Item
import kotlinx.android.synthetic.main.home_carousel_item_list.view.*

class HorizontalCarouselAdapter(
    private val context: Context, private val items: List<Item>, val itemClick: (position: Int, item: Item) -> Unit
) : RecyclerView.Adapter<HorizontalCarouselAdapter.ItemViewHolder>() {
    companion object {
        val TAG = this::class.java.simpleName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.home_carousel_item_list, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            itemClick(position, items[position])
        }
    }

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {
            Log.d(TAG, "Carousel Items is $item")
            view.list_item_background.setImageDrawable(context.getDrawable(item.icon))
        }
    }
}