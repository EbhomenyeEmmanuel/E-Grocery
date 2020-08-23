package com.esq.e_grocery.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.esq.e_grocery.R
import com.esq.e_grocery.data.FavouritesAdapter
import com.esq.e_grocery.utils.UtilAnimations
import com.esq.e_grocery.viewmodel.FavouritesViewModel
import kotlinx.android.synthetic.main.favourites_fragment.*

class FavouritesFragment : Fragment() {
    lateinit var favouritesAdapter: FavouritesAdapter

    companion object {
        val TAG = this::class.java.simpleName
        fun newInstance() = FavouritesFragment()
    }

    private lateinit var viewModel: FavouritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favourites_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavouritesViewModel::class.java)
        UtilAnimations.fadeInAnimation(favourites)
        activity?.initFavouriteAdapter()
    }

    private fun Context.initFavouriteAdapter() {
        val layoutManager = GridLayoutManager(this, 3)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        viewModel.favouritesRvData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Favourites Items is $it")
            favouritesAdapter = FavouritesAdapter(this, it)
            recyclerView.adapter = favouritesAdapter
        })
    }
}
