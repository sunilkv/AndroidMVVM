package com.gw.callingcard.data.network

import com.gw.callingcard.data.responses.EmployeeDashboardResponse
import com.gw.callingcard.data.responses.LoginResponse
import retrofit2.http.*

interface APIInterface {

    @GET("Auth/login")
   suspend fun  login( // suspend bez we use Asyncronous call using Co-routines
        @Query("phonenumber") phonenumber:String,
        @Query("password") password : String
    ):LoginResponse

   @GET("Employees/Dashboard")
   suspend fun employeeDashboard(
       @Query("id") empId:String
   ): EmployeeDashboardResponse


}