package com.gw.callingcard.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.data.repository.BaseRepository
import com.gw.callingcard.data.repository.HomeRepository
import com.gw.callingcard.ui.auth.AuthViewModel
import com.gw.callingcard.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory (private  val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {

    //this will create the ViewMOdel
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository  as AuthRepository) as T

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository  as HomeRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }

    }


}