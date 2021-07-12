package com.gw.callingcard.data.repository

import com.gw.callingcard.data.AppPreferences
import com.gw.callingcard.data.network.APIInterface

class HomeRepository (
    private val api: APIInterface,
    private val appPreferences: AppPreferences
        ) : BaseRepository() {
            
}