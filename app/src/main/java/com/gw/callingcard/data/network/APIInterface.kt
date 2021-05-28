package com.gw.callingcard.data.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIInterface {

    @FormUrlEncoded
    @POST("auth/login")
   suspend fun  login( // suspend bez we use Asyncronous call using Co-routines
        @Field("email") email:String,
        @Field("password") password : String
    ):Any
}