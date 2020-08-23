package com.esq.e_grocery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esq.e_grocery.domain.interfaces.AutheResultCallback

/**
 * ViewModel provider factory to instantiate SignUpViewModel.
 */
class SignUpViewModelFactory(private val autheResultCallback: AutheResultCallback) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            SignUpViewModel(this.autheResultCallback) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}