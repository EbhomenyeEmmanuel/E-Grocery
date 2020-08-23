package com.esq.e_grocery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esq.e_grocery.domain.interfaces.AutheResultCallback

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory(private val autheResultCallback: AutheResultCallback) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(this.autheResultCallback) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}