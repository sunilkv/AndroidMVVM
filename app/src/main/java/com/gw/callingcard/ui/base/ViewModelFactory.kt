package com.gw.callingcard.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.data.repository.BaseRepository
import com.gw.callingcard.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory (private  val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {

    //this will create the ViewMOdel
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository  as AuthRepository) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }

    }


}