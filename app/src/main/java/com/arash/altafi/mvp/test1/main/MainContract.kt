package com.arash.altafi.mvp.test1.main

interface MainContract {

    interface MainView {

        fun showSave()
        fun hideProgress()
        fun showProgress()
        fun onSuccess()

    }

    interface MainPresenter {

        fun handleSaveButton()
        fun onSuccess()

    }

}