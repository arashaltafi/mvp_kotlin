package com.arash.altafi.mvp.test1.login

class LoginPresenterImpl(private var view : LoginContract.LoginView) :
    LoginContract.LoginPresenter {

    override fun handleProperties() {
        view.showProperties()
    }

}