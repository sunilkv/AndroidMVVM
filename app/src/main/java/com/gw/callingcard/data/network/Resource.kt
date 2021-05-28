package com.gw.callingcard.data.network

import okhttp3.ResponseBody

//To handle the Error and success usng the Generic Class
//Sealed class is like abstract class which object cannot be created..
sealed class Resource<out T> {
    data class Success<out T>(val value: T):Resource<T>();
    data class Failure(
        val isNetworkError:Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ):Resource<Nothing>()

}