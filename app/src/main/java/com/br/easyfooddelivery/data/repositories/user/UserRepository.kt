package com.br.easyfooddelivery.data.repositories.user

import com.br.easyfooddelivery.data.repositories.user.contract.UserDataSource
import com.br.easyfooddelivery.data.repositories.user.source.UserLocalDataSource
import com.br.easyfooddelivery.data.repositories.user.source.UserRemoteDataSource

/**
 * Created by pedro on 05/02/18.
 */
class UserRepository(
        private val userRemoteDataSource: UserRemoteDataSource,
        private val userLocalDataSource: UserLocalDataSource
) : UserDataSource {
    override fun loginFacebook() {
        return userRemoteDataSource.loginFacebook()
    }
}