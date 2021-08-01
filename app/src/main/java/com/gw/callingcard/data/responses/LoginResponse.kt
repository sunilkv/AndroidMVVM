package com.gw.callingcard.data.responses

data class LoginResponse(
    val `data`: Data,
    val message: String,
    val success: Boolean
){
    data class Data(
        val role: Role,
        val user: User
    )
}

