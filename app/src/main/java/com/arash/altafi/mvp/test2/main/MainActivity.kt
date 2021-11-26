package com.arash.altafi.mvp.test2.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.mvp.R
import com.arash.altafi.mvp.test2.login.LoginActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() , MainContract.MainView {

    private lateinit var btnLogin : MaterialButton
    private lateinit var presenter : MainContract.MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        init()
    }

    private fun init() {
        bindViews()
        presenter = MainPresenterImpl(this)
        btnLogin.setOnClickListener {
            presenter.handleLoginButton()
        }
    }

    private fun bindViews() {
        btnLogin = findViewById(R.id.btn_login)
    }

    override fun showLoginView() {
        startActivity(Intent(this , LoginActivity::class.java))
    }

}