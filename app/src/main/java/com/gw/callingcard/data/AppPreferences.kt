package com.gw.callingcard.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences


class AppPreferences( context: Context){

    //**even though we are calling from the Fragment/Activity we will get the Application context here..
    val applicationContext =context.applicationContext;


    init {
    }


}