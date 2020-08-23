package com.esq.e_grocery.domain.model

import android.text.TextUtils
import android.util.Patterns

class SignUpUserModel(
    var email: String = "",
    var userName: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var homeAddress: String = ""
) {

    //Validate editText
    val isValidData: Int
        get() =//Validate editText
            if (TextUtils.isEmpty(email)) {
                1
            } else if (TextUtils.isEmpty(userName)) {
                2
            } else if (TextUtils.isEmpty(homeAddress)) {
                3
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                4
            } else if (TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                5
            } else if (password.length < 6 || confirmPassword.length < 6) {
                6
            } else if (password != confirmPassword) {
                7
            } else 8
}