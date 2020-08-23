package com.esq.e_grocery.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.domain.interfaces.AutheResultCallback
import com.esq.e_grocery.domain.model.LoggedUserModel

class LoginViewModel(
    private val autheResultCallback: AutheResultCallback,
    private val loggedUserModel: LoggedUserModel = LoggedUserModel()
) : ViewModel() {
    companion object {
        private val TAG = this::class.simpleName
    }

    //Write method to get Email from editText and set to user
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                loggedUserModel.userEmail = editable.toString().trim { it <= ' ' }
            }
        }

    //Write method to get Email from editText and set to user
    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                loggedUserModel.userPassword = editable.toString().trim { it <= ' ' }
            }
        }

    //Write method to send intent to start SignUpActivity
    fun onSendSignUpIntent(view: View) {
        Log.d(TAG, "onSendSignUpIntent: ")
        autheResultCallback.onSendIntent("$view clicked; Sending intent", view)
    }

    //Write method to send to reset password
    fun onClickForgotPassword(view: View) {
        Log.d(TAG, "onClickForgotPassword: ")
        autheResultCallback.onSendIntent("$view clicked; Sending intent", view)
    }

    //Write method to process Login - Button is clicked
    fun onLoginClicked(view: View?) {
        Log.d(TAG, "onLoginClicked: ")
        val errorCode: Int = loggedUserModel.isValidData
        if (errorCode == 1) {
            autheResultCallback.onError("Email is required", errorCode)
        } else if (errorCode == 2) {
            autheResultCallback.onError("Please enter a valid Email", errorCode)
        } else if (errorCode == 3) {
            autheResultCallback.onError("Please enter your password", errorCode)
        } else if (errorCode == 4) {
            autheResultCallback.onError("Password cannot be less than 6", errorCode)
        } else if (errorCode == 5) {
            //Set usercredentials in a string array since login data has been validated
            val arrayOfCredentials = arrayOf(
                loggedUserModel.userEmail,
                loggedUserModel.userPassword
            )
            loginCall(arrayOfCredentials)
            autheResultCallback.onSuccess(successMessage = loginCall(arrayOfCredentials))
        }
    }

    //Login by calling repo
    private fun loginCall(
        arrayOfCredentials: Array<String>
    ): String {
        //call repo
        return "Login was successful"
    }

}