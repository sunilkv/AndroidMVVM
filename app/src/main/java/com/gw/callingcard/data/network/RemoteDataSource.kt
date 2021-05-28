package com.gw.callingcard.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    //this nothing but a static Variable
    companion object{
         private const val BASE_URL="https://simplifiedcoding.tech/mywebapp/public/"
    }

    fun<Api> buildApi(
        api: Class<Api>
    ):Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api);
    }
}