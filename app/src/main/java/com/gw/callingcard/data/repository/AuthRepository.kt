package com.gw.callingcard.data.repository

import com.gw.callingcard.data.AppPreferences
import com.gw.callingcard.data.network.APIInterface

class AuthRepository(
        private val api: APIInterface,
        private val appPreferences: AppPreferences
) : BaseRepository(){

    // suspend bez we use Asyncronous call using Co-routines
    suspend fun login(
            email:String,
            password:String
    )=SafeApiCall{
        api.login(email,password)
    }


    suspend fun saveAuthToken(token:String){
        appPreferences.storeUserDetails(token)
    }
}