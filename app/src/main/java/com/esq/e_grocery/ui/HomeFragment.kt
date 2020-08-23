package com.esq.e_grocery.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.esq.e_grocery.R

import com.esq.e_grocery.data.HomePopularMenuAdapter
import com.esq.e_grocery.data.HorizontalCarouselAdapter
import com.esq.e_grocery.domain.model.Item
import com.esq.e_grocery.domain.model.PopularMenuItem
import com.esq.e_grocery.utils.shortToast
import com.esq.e_grocery.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.popular_menu_item_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    companion object {
        private val TAG = this::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    var noOfItems: Int = 0
    lateinit var itemCarouselAdapter: HorizontalCarouselAdapter
    lateinit var homePopularMenuAdapter: HomePopularMenuAdapter

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        activity?.initHorizontalAdapter()
        activity?.initPopularAdapter()

    }

    private fun Context.initHorizontalAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        viewModel.horizontalCategoriesRvData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Carousel Items is $it")
            itemCarouselAdapter = HorizontalCarouselAdapter(this, it) { position: Int, item: Item ->
                activity?.shortToast("Pos ${position}")
            }
            recyclerView.adapter = itemCarouselAdapter
        })
    }

    private fun Context.initPopularAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView2.layoutManager = layoutManager
        viewModel.menuData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Popular Items is $it")
            homePopularMenuAdapter =
                HomePopularMenuAdapter(this, it) { i: Int, popularMenuItem: PopularMenuItem ->
                    /* when (i) {
                          1 -> {
                              Log.d(TAG, "1 Clicked")
                              ibSingleAddItem.visibility = View.GONE
                              layout4Cart.visibility = View.VISIBLE
                              ++noOfItems
                          }
                          2, 3 -> {
                              Log.d(TAG, "$i clicked")
                              setListenersForItemClicked()
                          }
                      } */
                }

            recyclerView2.adapter = homePopularMenuAdapter
        })

    }

    private fun setListenersForItemClicked() {
        ibSubtractItem.setOnClickListener { if (noOfItems >= 1) --noOfItems }
        ibAddItem.setOnClickListener { ++noOfItems }
        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                if (noOfItems == 0) {
                    layout4Cart.visibility = View.GONE
                    ibSingleAddItem.visibility = View.VISIBLE
                }
                Log.d(TAG, "Number of items variable is $noOfItems")
                tvNoOfItem.text = "$noOfItems"
            }
        }
    }
}
