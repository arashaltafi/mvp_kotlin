package com.arash.altafi.mvp.test2.main

interface MainContract {

    interface MainView {
        fun showLoginView()
    }

    interface MainPresenter {
        fun handleLoginButton()
    }

}