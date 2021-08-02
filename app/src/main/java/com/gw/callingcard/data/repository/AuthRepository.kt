package com.gw.callingcard.data.repository

import com.gw.callingcard.data.AppPreferences
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.responses.Role
import com.gw.callingcard.data.responses.User

class AuthRepository(
        private val api: APIInterface,
        private val appPreferences: AppPreferences
) : BaseRepository(){

    // suspend bez we use Asyncronous call using Co-routines
    suspend fun login(
            phonenumber:String,
            password:String
    )=SafeApiCall{
        api.login(phonenumber,password)
    }


    suspend fun saveAuthToken(user: User, roles: Role){
        appPreferences.storeUserDetails(user, roles)
    }


}