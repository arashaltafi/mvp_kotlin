package com.arash.altafi.mvp.test1.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.arash.altafi.mvp.test1.Keys
import com.arash.altafi.mvp.R

class LoginActivity : AppCompatActivity() , LoginContract.LoginView {

    private lateinit var txtName : TextView
    private lateinit var txtUsername : TextView
    private lateinit var txtPassword : TextView

    private lateinit var presenter : LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_1)

        init()
    }

    private fun init() {
        bindViews()
        presenter = LoginPresenterImpl(this)
        presenter.handleProperties()
    }

    override fun showProperties() {
        txtName.text = intent.getStringExtra(Keys.NAME)
        txtUsername.text = intent.getStringExtra(Keys.USERNAME)
        txtPassword.text = intent.getIntExtra(Keys.PASSWORD,0).toString()
    }

    private fun bindViews() {
        txtName = findViewById(R.id.txt_name)
        txtUsername = findViewById(R.id.txt_username)
        txtPassword = findViewById(R.id.txt_password)
    }

}