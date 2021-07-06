package com.gw.callingcard.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.data.repository.BaseRepository
import com.gw.callingcard.data.responses.LoginResponse
import kotlinx.coroutines.launch

//Repository as constructor paremeter
class AuthViewModel(
        private  val repository: AuthRepository
) :ViewModel(){

        private  val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

        //live data to get the response of the login fun
        //Will access outside the class but this are Immutable..
        val loginResponse : LiveData<Resource<LoginResponse>> get() =_loginResponse //assinging the livedata result


        fun login( email:String, password:String)=viewModelScope.launch {
                _loginResponse.value = repository.login(email,password)
        }

        fun saveAuthToken(authtoken:String)=viewModelScope.launch { repository.saveAuthToken(authtoken) }


}