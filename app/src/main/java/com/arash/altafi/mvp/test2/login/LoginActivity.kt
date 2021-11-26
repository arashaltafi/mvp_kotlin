package com.arash.altafi.mvp.test2.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.arash.altafi.mvp.R
import com.arash.altafi.mvp.test2.login.data.UserCredential
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() , LoginContract.LoginView {

    private lateinit var edtUsername : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnSignin : MaterialButton
    private lateinit var progressbar : ProgressBar
    private lateinit var presenter : LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_2)

        init()
    }

    private fun init() {
        bindViews()

        btnSignin.setOnClickListener {
            presenter = LoginPresenterImpl(this)
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()
            val userCredential = UserCredential(username , password)
            presenter.doLogin(userCredential)
        }
    }

    private fun bindViews() {
        edtPassword = findViewById(R.id.edt_password)
        edtUsername = findViewById(R.id.edt_username)
        btnSignin = findViewById(R.id.btn_signin)
        progressbar = findViewById(R.id.pr_loading)
    }

    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
        btnSignin.visibility = View.GONE
    }

    override fun hideLoading() {
//        Handler(Looper.getMainLooper()).postDelayed({
//            progressbar.visibility = View.GONE
//            btnSignin.visibility = View.VISIBLE
//        }, 4000)

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            progressbar.visibility = View.GONE
            btnSignin.visibility = View.VISIBLE
        },1000)
    }

    override fun onError(message: String) {
        Toast.makeText(this , message , Toast.LENGTH_LONG).show()
    }

    override fun onSuccess() {
        Toast.makeText(this , "Login Succeed!" , Toast.LENGTH_LONG).show()
    }

}