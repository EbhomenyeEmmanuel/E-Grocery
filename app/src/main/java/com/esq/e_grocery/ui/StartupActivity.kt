package com.esq.e_grocery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esq.e_grocery.R
import com.esq.e_grocery.utils.UtilAnimations
import kotlinx.android.synthetic.main.activity_startup.*

class StartupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
        UtilAnimations.fadeInAnimation(startUp)
        loginButton.setOnClickListener { startActivity(Intent(this@StartupActivity, LoginActivity::class.java)) }
        registerButton.setOnClickListener { startActivity(Intent(this@StartupActivity, SignUpActivity::class.java))  }
    }
}
