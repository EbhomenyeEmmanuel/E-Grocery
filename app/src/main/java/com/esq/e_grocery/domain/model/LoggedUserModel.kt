package com.esq.e_grocery.domain.model

/**
 * Model Data class for users that want to login
 */
class LoggedUserModel(
    var userPassword: String = "",
    var userEmail: String = ""
)