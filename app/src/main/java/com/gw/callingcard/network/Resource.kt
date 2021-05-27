package com.gw.callingcard.network

import android.net.sip.SipErrorCode
import okhttp3.ResponseBody
import retrofit2.http.Body

//To handle the Error and success usng the Generic Class
sealed class Resource<out T> {
    data class Success<out T>(val value: T):Resource<T>();
    data class Failure(
        val isNetworkError:Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    )

}