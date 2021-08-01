package com.gw.callingcard.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AppPreferences( context: Context){

    //**even though we are calling from the Fragment/Activity we will get the Application context here..
    val applicationContext =context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
                name = "app_preferences"
        )
    }


    //Prefrecen work based on the Key value,, so create a list of Key to access..
    companion object{
        private  val KEY_AUTH= preferencesKey<String>("keyAuth")
    }

    //Adding a data to a preferences..
    suspend fun  storeUserDetails(authtoken:String){
        dataStore.edit { preferences->
            preferences[KEY_AUTH]=authtoken
        }
    }


    //Read the Stored Data ..
    //we need to coroutines FLOW to read data..
    val authToken:Flow<String?> // nullable  if no value  return null.
        get() =dataStore.data.map { preferences->
            preferences[KEY_AUTH]
        }


}