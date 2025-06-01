package com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    @SerialName("password")
    val password: String,
    @SerialName("username")
    val username: String
)