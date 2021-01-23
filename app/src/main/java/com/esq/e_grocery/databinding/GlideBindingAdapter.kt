package com.esq.e_grocery.databinding

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.esq.e_grocery.R

class GlideBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImage(view: ImageView, imageUrl: Int) {
            val context: Context = view.context
            val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageUrl)
                .into(view)
        }
    }
}