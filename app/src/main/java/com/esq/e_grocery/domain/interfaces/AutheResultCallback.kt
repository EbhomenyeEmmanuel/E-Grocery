package com.esq.e_grocery.domain.interfaces

import android.view.View

/*
 *Interface for AuthenticationResult
 */
interface AutheResultCallback {
    fun onSuccess( successMessage: String)
    fun onError(errorMessage: String, errorCode: Int)
    fun onSendIntent(intentInfo: String, view: View)
}