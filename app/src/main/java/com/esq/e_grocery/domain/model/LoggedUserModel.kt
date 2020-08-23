package com.esq.e_grocery.domain.model

import android.text.TextUtils
import android.util.Patterns

/**
 * Model Data class for users that want to login
 */
class LoggedUserModel( var userPassword: String = "",
                       var userEmail: String = "") {

    //Validate editText
    val isValidData: Int
        get() =//Validate editText
            if (TextUtils.isEmpty(userEmail)) {
                1
            } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                2
            } else if (TextUtils.isEmpty(userPassword)) {
                3
            } else if (userPassword.length < 6) {
                4
            } else 5
}