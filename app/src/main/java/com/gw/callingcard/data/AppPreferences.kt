package com.gw.callingcard.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.gw.callingcard.data.responses.Role
import com.gw.callingcard.data.responses.User
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
        private  val KEY_Name= preferencesKey<String>("KeyName")
        private  val Key_Role= preferencesKey<String>("KeyRole")
        private  val Key_RoleName= preferencesKey<String>("KeyRoleName")
        private  val Key_PhoneNumber= preferencesKey<String>("Key_PhoneNumber")
        private  val Key_userId= preferencesKey<String>("keyId")
        private  val Key_userprofile= preferencesKey<String>("Key_userprofile")
    }

    //Adding a data to a preferences..
    suspend fun  storeUserDetails(user: User,role: Role){
        dataStore.edit { preferences->
            preferences[KEY_Name]=user.name.toString()
            preferences[Key_Role]=user.user_role_id.toString()
            preferences[Key_PhoneNumber]=user.phonenumber.toString()
            preferences[Key_userId]=user.id.toString()
            preferences[Key_userprofile]=user.profile_photo_url.toString()
            preferences[Key_RoleName]=role.roles_name.toString()
        }
    }




    //Read the Stored Data ..
    //we need to coroutines FLOW to read data..
    val authToken:Flow<String?> // nullable  if no value  return null.
        get() =dataStore.data.map { preferences->
            preferences[KEY_Name]
            preferences[Key_Role]
            preferences[Key_PhoneNumber]
            preferences[Key_userId]
            preferences[Key_userprofile]
            preferences[Key_RoleName]
        }


}