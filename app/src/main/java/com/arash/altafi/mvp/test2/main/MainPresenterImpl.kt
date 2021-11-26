package com.arash.altafi.mvp.test2.main

class MainPresenterImpl(private val view : MainContract.MainView) : MainContract.MainPresenter {

    override fun handleLoginButton() {
        view.showLoginView()
    }

}