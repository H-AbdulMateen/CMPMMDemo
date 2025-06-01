package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.ktor

import com.abdulmateen.cmpmmdemo.core.domain.DataError
import com.abdulmateen.cmpmmdemo.core.domain.Result
import com.abdulmateen.cmpmmdemo.core.network.ktor.safeCall
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.dto.LoginRequestDto
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.dto.LoginResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

private const val BASE_URL = "https://fakestoreapi.com/"

class KtorUserDataSource(
    private val httpClient: HttpClient
): RemoteUserDataSource  {
    override suspend fun login(
        username: String,
        password: String
    ): Result<LoginResponseDto, DataError.Remote> {
        return safeCall<LoginResponseDto> {
            httpClient.post(
                urlString = BASE_URL + "auth/login"
            ) {
                setBody(
                    LoginRequestDto(
                        username = username,
                        password = password
                    )
                )
            }
        }
    }
}