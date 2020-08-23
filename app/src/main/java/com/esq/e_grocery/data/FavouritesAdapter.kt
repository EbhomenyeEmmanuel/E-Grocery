package com.esq.e_grocery.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esq.e_grocery.R
import com.esq.e_grocery.domain.model.Item
import kotlinx.android.synthetic.main.favourite_item_list.view.*

class FavouritesAdapter(
    private val context: Context, private val items: List<Item>
) : RecyclerView.Adapter<FavouritesAdapter.ItemViewHolder>() {
    companion object {
        private val TAG = this::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.favourite_item_list, parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {
            Log.d(TAG, "Fav Items is $item")
            view.ivfavIcon.setImageDrawable(context.getDrawable(item.icon))
        }
    }
}