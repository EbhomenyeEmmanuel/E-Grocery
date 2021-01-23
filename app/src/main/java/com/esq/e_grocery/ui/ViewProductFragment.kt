package com.esq.e_grocery.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esq.e_grocery.R

import com.esq.e_grocery.databinding.ViewProductFragmentBinding
import com.esq.e_grocery.domain.model.PopularProducts
import com.esq.e_grocery.viewmodel.ViewProductViewModel

/**
 * [Fragment] for viewing product after an item in the list is clicked.
 */

class ViewProductFragment : Fragment() {

    companion object {
        fun newInstance() = ViewProductFragment()
    }

    private lateinit var mItem: PopularProducts
    private val viewModel: ViewProductViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this).get(ViewProductViewModel::class.java)
    }
    private lateinit var binding: ViewProductFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewProductFragmentBinding.inflate(inflater)
        binding.product = viewModel.mItem
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saveCurrentProductToViewModel(this.arguments)

        if (viewModel.isNewlyCreated && savedInstanceState != null) {
            viewModel.restoreState(savedInstanceState)
        }
        viewModel.isNewlyCreated = false
    }

    private fun saveCurrentProductToViewModel(arguments: Bundle?) {
        arguments?.let {
            viewModel.mItem = it.getParcelable(getString(R.string.intent_product))!!
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        viewModel.saveState(outState)
    }

}
