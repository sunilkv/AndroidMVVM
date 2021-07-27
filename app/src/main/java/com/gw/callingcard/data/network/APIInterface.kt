package com.gw.callingcard.data.network

import com.gw.callingcard.data.responses.LoginResponse
import retrofit2.http.*

interface APIInterface {

    @GET("Auth/login")
   suspend fun  login( // suspend bez we use Asyncronous call using Co-routines
        @Query("email") email:String,
        @Query("password") password : String
    ):LoginResponse
}