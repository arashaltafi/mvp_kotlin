package com.arash.altafi.mvp.test2.login.data

import com.arash.altafi.mvp.test2.login.LoginContract
import java.util.*

class LoginInteractor(private val presenter : LoginContract.LoginPresenter) {

    fun login (userCredential: UserCredential) {
        if (hasError(userCredential)) {
            return
        }
        presenter.onSuccess()
    }

    private fun hasError(userCredential: UserCredential): Boolean {
        if (userCredential.username.isEmpty() || userCredential.password.isEmpty()) {
            presenter.onError("Please Enter Username And Password")
            return true
        }
        //fixme: load user info from database or api by username and password
        val user = UserCredential("admin" , "123")
        // lowercase   تبدیل به حروف کوچک
        if (userCredential.username.lowercase(Locale.getDefault()) != user.username.lowercase(Locale.getDefault()) || userCredential.password != user.password) {
            presenter.onError("Incorrect Username Or Password")
            return true
        }
        return false
    }

}