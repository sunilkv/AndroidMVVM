package com.gw.callingcard.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.HomeRepository
import com.gw.callingcard.data.responses.EmployeeDashboardResponse
import com.gw.callingcard.data.responses.LoginResponse
import kotlinx.coroutines.launch

class HomeViewModel(
    private  val repository: HomeRepository
) : ViewModel()  {

//Intializing the Mutable Live data..
    private  val _employeeDashboardResponse:MutableLiveData<Resource<EmployeeDashboardResponse>> =MutableLiveData()

    //live data to get the response of the login fun
    //Will access outside the class but this are Immutable..
    val employeeDashboardResponse : LiveData<Resource<EmployeeDashboardResponse>> get() =_employeeDashboardResponse //assinging the livedata result


    fun getEmployeeDashboard(empID:String)=viewModelScope.launch {
        _employeeDashboardResponse.value= repository.employeeDashboard(empID)
    }



}