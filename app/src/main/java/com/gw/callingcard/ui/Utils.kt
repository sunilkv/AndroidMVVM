package com.gw.callingcard.ui

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.ui.auth.LoginFragment
import kotlinx.coroutines.launch


//Utils to Store Some Common files..

//to Start A Fresh Activity
fun<A: Activity>  Activity.startNewActivity(activity: Class<A>){
    startActivity(Intent(this,activity).also {
        it.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
    

}

//
fun View.visible(isVisible:Boolean){
    visibility= if(isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled:Boolean){
   isEnabled = enabled
    alpha= if(enabled) 1f else 0.5f
}


fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}


fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {

        failure.errorCode == 401 -> {
            if (this is LoginFragment) {
                requireView().snackbar("You've entered incorrect email or password")
            }
        }
        failure.isNetworkError -> requireView().snackbar(
            "Please check your internet connection",
            retry
        )
        else -> {
            val error = failure.errorBody?.string().toString()
            requireView().snackbar(error)
        }
    }
}

