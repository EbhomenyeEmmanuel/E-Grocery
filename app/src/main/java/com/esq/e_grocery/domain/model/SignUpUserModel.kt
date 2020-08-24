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

}