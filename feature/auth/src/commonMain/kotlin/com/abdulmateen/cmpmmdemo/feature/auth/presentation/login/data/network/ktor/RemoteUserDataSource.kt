package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.ktor

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.dto.LoginResponseDto

interface RemoteUserDataSource {
    suspend fun login(username: String, password: String): Result<LoginResponseDto, DataError.Remote>
}