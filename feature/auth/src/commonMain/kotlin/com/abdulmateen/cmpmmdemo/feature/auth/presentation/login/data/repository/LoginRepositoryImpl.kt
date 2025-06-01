package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.repository

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.core.domain.map
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.ktor.RemoteUserDataSource
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.domain.LoginRepository

class LoginRepositoryImpl(
    private val remoteUserDataSource: RemoteUserDataSource
): LoginRepository {
    override suspend fun login(
        username: String,
        password: String
    ): Result<String, DataError.Remote> {
        return remoteUserDataSource.login(username, password).map { it.token }
    }

}