package com.arash.altafi.mvp.test1.main

class MainPresenterImpl(private var view : MainContract.MainView) : MainContract.MainPresenter {

    override fun handleSaveButton() {
        view.showProgress()
        view.showSave()
    }

    override fun onSuccess() {
        view.hideProgress()
        view.onSuccess()
    }

}