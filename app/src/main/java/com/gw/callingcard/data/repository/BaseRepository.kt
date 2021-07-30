package com.gw.callingcard.data.repository

import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.responses.EmployeeDashboardResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> SafeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        //Coroutine Scope
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }

    }

}