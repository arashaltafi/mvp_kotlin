package com.arash.altafi.mvp.test1.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.arash.altafi.mvp.test1.Keys
import com.arash.altafi.mvp.R
import com.arash.altafi.mvp.test1.login.LoginActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() , MainContract.MainView {

    private lateinit var edtPassword : EditText
    private lateinit var edtUsername : EditText
    private lateinit var edtName : EditText
    private lateinit var btnSave : MaterialButton
    private lateinit var prLoading : ProgressBar

    private lateinit var presenter : MainContract.MainPresenter

    var username : String ?= null
    var password : String ?= null
    var name : String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_1)

        init()
    }

    private fun init() {
        bindViews()
        presenter = MainPresenterImpl(this)

        btnSave.setOnClickListener {
            username = edtUsername.text.toString().trim()
            name = edtName.text.toString().trim()
            password = edtPassword.text.toString().trim()
            presenter.handleSaveButton()
        }
    }

    override fun showSave() {
        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            startActivity(Intent(this , LoginActivity::class.java).apply {
                putExtra(Keys.USERNAME , username)
                putExtra(Keys.NAME , name)
                putExtra(Keys.PASSWORD , password)
                hideProgress()
            })
        },1000)
    }

    override fun hideProgress() {
        prLoading.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }

    override fun showProgress() {
        prLoading.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    override fun onSuccess() {
        Toast.makeText(this , "Login Succeed!" , Toast.LENGTH_LONG).show()
    }

    private fun bindViews() {
        edtName = findViewById(R.id.edt_name)
        edtPassword = findViewById(R.id.edt_password)
        edtUsername = findViewById(R.id.edt_username)
        btnSave = findViewById(R.id.btn_save)
        prLoading = findViewById(R.id.pr_loading)
    }

}