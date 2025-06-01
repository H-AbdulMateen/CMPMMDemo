package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.domain

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result

interface LoginRepository {
    suspend fun login(username: String, password: String): Result<String, DataError.Remote>
}