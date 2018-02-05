package com.br.easyfooddelivery.data.repositories.user.source

import com.br.easyfooddelivery.data.repositories.user.contract.UserDataSource
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

/**
 * Created by pedro on 05/02/18.
 */
class UserRemoteDataSource(private val callbackFacebook: CallbackManager) : UserDataSource {
    override fun loginFacebook() {
        LoginManager.getInstance().registerCallback(callbackFacebook, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onCancel() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(error: FacebookException?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}