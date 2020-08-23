package com.esq.e_grocery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.esq.e_grocery.MainActivity
import com.esq.e_grocery.R
import com.esq.e_grocery.databinding.ActivitySignUpBinding
import com.esq.e_grocery.domain.interfaces.AutheResultCallback
import com.esq.e_grocery.utils.requestFocusWithErrorMessage
import com.esq.e_grocery.utils.shortToast
import com.esq.e_grocery.viewmodel.SignUpViewModel
import com.esq.e_grocery.viewmodel.SignUpViewModelFactory
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), AutheResultCallback {
lateinit var bind: ActivitySignUpBinding
    private val _viewModel by lazy {
        ViewModelProvider(this, SignUpViewModelFactory(this)).get(SignUpViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        bind.viewModel = _viewModel
    }

    override fun onSuccess(successMessage: String) {
        shortToast(successMessage)
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onError(errorMessage: String, errorCode: Int) {
        //Request focus on editText
        when (errorCode) {
            1, 4 -> {
                emailEditText.requestFocusWithErrorMessage(errorMessage)
            }
            2 -> {
                userNameEditText.requestFocusWithErrorMessage(errorMessage)
            }
            3 -> {
                homeAddressEditText.requestFocusWithErrorMessage(errorMessage)
            }
            5, 6, 7 -> {
                passwordEditText.requestFocusWithErrorMessage(errorMessage)
            }
        }

    }

    override fun onSendIntent(intentInfo: String, view: View) {
        if (view === tvTermsOfService) {
            //startActivity(Intent(this, ForgetPasswordActivity::class.java))
            //finish()
        } else if (view === tvPrivacyPolicy) {
            //startActivity(Intent(this, SignUpActivity::class.java))
            // finish()
        }
    }
}
