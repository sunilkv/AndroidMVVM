package com.gw.callingcard.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.data.responses.LoginResponse
import com.gw.callingcard.data.responses.Role
import com.gw.callingcard.data.responses.User
import kotlinx.coroutines.launch

//Repository as constructor paremeter
class AuthViewModel(
        private  val repository: AuthRepository
) :ViewModel(){

        private  val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

        //live data to get the response of the login fun
        //Will access outside the class but this are Immutable..
        val loginResponse : LiveData<Resource<LoginResponse>> get() =_loginResponse //assinging the livedata result


        fun login( phonenumbr:String, password:String)=viewModelScope.launch {
                _loginResponse.value = repository.login(phonenumbr,password)
        }

     suspend   fun saveAuthToken(user: User, role: Role)=
             repository.saveAuthToken(user,role)


}