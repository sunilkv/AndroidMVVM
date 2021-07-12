package com.gw.callingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.gw.callingcard.data.AppPreferences
import com.gw.callingcard.ui.auth.AuthActivity
import com.gw.callingcard.ui.home.HomeActivity
import com.gw.callingcard.ui.startNewActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appPreferences = AppPreferences(this)


        appPreferences.authToken.asLiveData().observe(this, Observer {
            //adding the Loading for 3ms.. splash Screen..
            lifecycleScope.launch {
                delay(4000)
                if (it == null)
                    startNewActivity(AuthActivity::class.java)
                else
                    startNewActivity(HomeActivity::class.java)
            }

        })

    }
}