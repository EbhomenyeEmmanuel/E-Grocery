package com.esq.e_grocery.viewmodel

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.lifecycle.ViewModel
import com.esq.e_grocery.domain.interfaces.AutheResultCallback
import com.esq.e_grocery.domain.model.SignUpUserModel

class SignUpViewModel(
    var resultCallback: AutheResultCallback,
    private val signUpUserModel: SignUpUserModel = SignUpUserModel()
) : ViewModel() {
    companion object {
        private val TAG = this::class.java.simpleName
    }

    val userNameTextWatcher: TextWatcher
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
                signUpUserModel.userName = editable.toString().trim { it <= ' ' }
            }
        }

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
                signUpUserModel.email = editable.toString().trim { it <= ' ' }
            }
        }

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
                signUpUserModel.password = editable.toString().trim { it <= ' ' }
            }
        }

    val confirmPasswordTextWatcher: TextWatcher
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
                signUpUserModel.confirmPassword = editable.toString().trim { it <= ' ' }
            }
        }

    val homeAddressTextWatcher: TextWatcher
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
                signUpUserModel.homeAddress = editable.toString().trim { it <= ' ' }
            }
        }

    //Write method to process Login
    fun onSignUpClicked(view: View) {
        when (val errorCode: Int = isValidData(signUpUserModel)) {
            1, 4 -> {
                resultCallback.onError("Please enter a valid Email", errorCode)
            }
            2 -> {
                resultCallback.onError("Username is required", errorCode)
            }
            3 -> {
                resultCallback.onError("Home address is required", errorCode)
            }
            5 -> {
                resultCallback.onError("Please enter your password", errorCode)
            }
            6 -> {
                resultCallback.onError("Password cannot be less than 6", errorCode)
            }
            7 -> {
                resultCallback.onError("Passwords don't match", errorCode)
            }
            8 -> {
                //Set usercredentials in a string array since sign up data has been validated
                val arrayOfCredentials = arrayOf<String>(
                    signUpUserModel.email,
                    signUpUserModel.userName,
                    signUpUserModel.password,
                    signUpUserModel.confirmPassword,
                    signUpUserModel.homeAddress
                )
                Log.d(  TAG, "onSignUpClicked: Validation successful"  )
                resultCallback.onSuccess( successMessage = signUpCall(arrayOfCredentials) )
            }
        }
    }

    //Validate editText
    private fun isValidData(signUpUserModel: SignUpUserModel): Int  = //Validate editText
            if (TextUtils.isEmpty(signUpUserModel.email)) {
                1
            } else if (TextUtils.isEmpty(signUpUserModel.userName)) {
                2
            } else if (TextUtils.isEmpty(signUpUserModel.homeAddress)) {
                3
            } else if (!Patterns.EMAIL_ADDRESS.matcher(signUpUserModel.email).matches()) {
                4
            } else if (TextUtils.isEmpty(signUpUserModel.password) || TextUtils.isEmpty(signUpUserModel.confirmPassword)) {
                5
            } else if (signUpUserModel.password.length < 6 || signUpUserModel.confirmPassword.length < 6) {
                6
            } else if (signUpUserModel.password != signUpUserModel.confirmPassword) {
                7
            } else 8

    fun onSendIntent(view: View) {
        Log.d(TAG, "onSendLoginIntent: ")
        resultCallback.onSendIntent( "$view clicked", view )
    }

    //Sign up by calling repo
    private fun signUpCall( arrayOfCredentials: Array<String> ): String {
        //Call repo
        return "Sign up successful"
    }

}