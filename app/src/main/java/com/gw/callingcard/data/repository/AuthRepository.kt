package com.gw.callingcard.data.repository

import com.gw.callingcard.data.network.APIInterface

class AuthRepository(
        private val api: APIInterface
) : BaseRepository(){


    suspend fun login(
            email:String,
            password:String
    )=SafeApiCall{
        api.login(email,password)
    }

}