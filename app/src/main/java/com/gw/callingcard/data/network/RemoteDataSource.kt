package com.gw.callingcard.data.network

import com.gw.callingcard.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Same as APIClient
class RemoteDataSource {

    //this nothing but a static Variable
    companion object{
         private const val BASE_URL="https://simplifiedcoding.tech/mywebapp/public/api/"
    }

    fun<Api> buildApi(
        api: Class<Api>
    ):Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also {
                client->
                if(BuildConfig.DEBUG) {  // get ApI Request and response log in Logcat..
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }

            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api);
    }
}