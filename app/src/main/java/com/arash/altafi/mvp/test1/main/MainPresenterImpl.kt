package com.arash.altafi.mvp.test1.main

class MainPresenterImpl(private var view : MainContract.MainView) : MainContract.MainPresenter {

    override fun handleSaveButton() {
        view.showSave()
    }

}