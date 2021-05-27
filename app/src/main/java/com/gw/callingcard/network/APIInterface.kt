package com.gw.callingcard.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIInterface {

    @FormUrlEncoded
    @POST("auth/login")
    fun  login(
        @Field("email") email:String,
        @Field("password") password : String
    ):Any
}