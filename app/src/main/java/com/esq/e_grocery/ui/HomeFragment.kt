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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.esq.e_grocery.data.HomePopularMenuAdapter
import com.esq.e_grocery.data.HorizontalCarouselAdapter
import com.esq.e_grocery.databinding.HomeFragmentBinding
import com.esq.e_grocery.domain.interfaces.SearchQueryResultCallback
import com.esq.e_grocery.domain.model.Item
import com.esq.e_grocery.utils.UtilAnimations
import com.esq.e_grocery.utils.shortToast
import com.esq.e_grocery.viewmodel.HomeViewModel
import com.esq.e_grocery.viewmodel.HomeViewModelFactory

/***
 * [Fragment] for showing the main UI
 */
class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, SearchQueryResultCallback {

    companion object {
        private val TAG = this::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    var noOfItems: Int = 0
    lateinit var itemCarouselAdapter: HorizontalCarouselAdapter
    lateinit var homePopularMenuAdapter: HomePopularMenuAdapter
    lateinit var bind: HomeFragmentBinding

    private val viewModel: HomeViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, HomeViewModelFactory(this)).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = HomeFragmentBinding.inflate(inflater)
       bind.swipeRefreshLayout.setOnRefreshListener(this)
        return bind.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (viewModel.isNewlyCreated && savedInstanceState != null) {
            viewModel.restoreState(savedInstanceState)
        }
        viewModel.isNewlyCreated = false
    }

    override fun onRefresh() {
        viewModel.mMenuData.observe(viewLifecycleOwner, Observer {
            (bind.recyclerView2.adapter as HomePopularMenuAdapter).refreshList(it)
        })
        onItemLoadComplete()
    }

    private fun onItemLoadComplete() {
        bind.recyclerView2.adapter?.notifyDataSetChanged()
        bind.swipeRefreshLayout.isRefreshing = false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bind.viewModel = viewModel
        UtilAnimations.fadeInAnimation(bind.home)
        UtilAnimations.hoverViewAnimation(bind.imageView2)
        activity?.initHorizontalAdapter()
        initPopularList()

    }

    private fun Context.initHorizontalAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        bind.recyclerView.layoutManager = layoutManager
        viewModel.horizontalCategoriesRvData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Carousel Items is $it")
            itemCarouselAdapter = HorizontalCarouselAdapter(this, it) { position: Int, item: Item ->
                activity?.shortToast("Pos ${position}")
            }
            bind.recyclerView.adapter = itemCarouselAdapter
        })
    }

    private fun initPopularList() {
        viewModel.mMenuData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Popular Items is $it")
            bind.popularItemList = it
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
            viewModel.saveState(outState)
    }

    override fun onSuccessfulQuery(mSearchQuery: String?) {
        val searchQuery = viewModel.searchKey
        //TODO Use search key to search
    }

    override fun onFailedQuery(errorMessage: String) {
        activity?.shortToast(errorMessage)
    }

}