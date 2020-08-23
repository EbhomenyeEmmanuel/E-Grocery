package com.esq.e_grocery.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.esq.e_grocery.MainActivity
import com.esq.e_grocery.R
import com.esq.e_grocery.databinding.ActivityLoginBinding
import com.esq.e_grocery.domain.interfaces.AutheResultCallback
import com.esq.e_grocery.utils.requestFocusWithErrorMessage
import com.esq.e_grocery.utils.shortToast
import com.esq.e_grocery.viewmodel.LoginViewModel
import com.esq.e_grocery.viewmodel.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AutheResultCallback {
    lateinit var bind: ActivityLoginBinding
    private val _viewModel by lazy {
        ViewModelProvider(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_login)
        bind.viewModel = _viewModel
    }

    override fun onSuccess(successMessage: String) {
        shortToast(successMessage)
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onError(errorMessage: String, errorCode: Int) {
        //Request focus on editText
        if (errorCode == 1 || errorCode == 2) {
            bind.emailEditText.requestFocusWithErrorMessage(errorMessage)
        } else {
            bind.passwordEditText.requestFocusWithErrorMessage(errorMessage)
        }
    }

    //Go back to SignUp screen since user doesnt have an account
    override fun onSendIntent(intentInfo: String, view: View) {
        if (view === textViewForgot) {
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
            finish()
        } else if (view === textViewSignUp) {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}
