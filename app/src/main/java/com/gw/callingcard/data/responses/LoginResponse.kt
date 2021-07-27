package com.gw.callingcard.data.responses

data class LoginResponse(

    val data: User,
    val success:Boolean,
    val message:String
)