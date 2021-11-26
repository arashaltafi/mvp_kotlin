package com.arash.altafi.mvp.test1.main

interface MainContract {

    interface MainView {

        fun showSave()

    }

    interface MainPresenter {

        fun handleSaveButton()

    }

}