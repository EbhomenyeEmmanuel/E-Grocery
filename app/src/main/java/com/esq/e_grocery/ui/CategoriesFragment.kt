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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.esq.e_grocery.R
import com.esq.e_grocery.data.CategoriesAdapter
import com.esq.e_grocery.utils.UtilAnimations
import com.esq.e_grocery.viewmodel.CategoriesViewModel
import kotlinx.android.synthetic.main.categories_fragment.*

class CategoriesFragment : Fragment() {
    lateinit var categoriesAdapter: CategoriesAdapter

    companion object {
        val TAG = this::class.java.simpleName
        fun newInstance() = CategoriesFragment()
    }

    private lateinit var viewModel: CategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.categories_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        UtilAnimations.fadeInAnimation(categories)
        activity?.initCategoriesAdapter()
    }

    private fun Context.initCategoriesAdapter() {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        viewModel.categoriesRvData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Categories Items is $it")
            categoriesAdapter = CategoriesAdapter(this, it)
            recyclerView.adapter = categoriesAdapter
        })
    }

}
