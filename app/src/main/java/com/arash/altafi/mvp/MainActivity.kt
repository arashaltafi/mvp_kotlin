package com.arash.altafi.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.mvp.test1.main.MainActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btn1 : MaterialButton
    private lateinit var btn2 : MaterialButton
    private lateinit var btn3 : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_main)

        init()
    }

    private fun init() {
        bindViews()

        btn1.setOnClickListener {
            startActivity(Intent(this , com.arash.altafi.mvp.test1.main.MainActivity::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this , com.arash.altafi.mvp.test2.main.MainActivity::class.java))
        }
    }

    private fun bindViews() {
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
    }

}