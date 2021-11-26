package com.arash.altafi.mvp.test2.login

import com.arash.altafi.mvp.test2.login.data.UserCredential

interface LoginContract {

    interface LoginView {

        fun showLoading()
        fun hideLoading()
        fun onError(message : String)
        fun onSuccess()

    }

    interface LoginPresenter {

        fun doLogin(userCredential: UserCredential)
        fun onError(message : String)
        fun onSuccess()

    }

}