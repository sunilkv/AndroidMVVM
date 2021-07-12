package com.gw.callingcard.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.gw.callingcard.data.AppPreferences
import com.gw.callingcard.data.network.RemoteDataSource
import com.gw.callingcard.data.repository.BaseRepository

//Common Stuff related to fragment we are going to do here..
//Databinding , viewmodel, Repository
abstract class BaseFragment<VM: ViewModel,B:ViewBinding,R:BaseRepository>: Fragment() {


    //as the name convey it may be iniatized late..
    protected  lateinit var binding: B
    //View Model
    protected lateinit var viewModel:VM
    //REmote APi Datasource instance  to call API
    protected  val remoteDataSource= RemoteDataSource()

    //Shared preferences..
    protected lateinit var appPreferences:AppPreferences


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        appPreferences= AppPreferences(requireContext())
        binding=getFragmentBinding(inflater,container)
        //Created Viewmodel factory Instanace with Constructor consit of Repository..
        val factory =ViewModelFactory(getFragmentRepository())
        //Get the View Model from the Factory..
        viewModel =ViewModelProvider(this,factory).get(getViewModel())
        //
        return binding.root
    }

    abstract fun getViewModel():Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?):B
    abstract fun getFragmentRepository():R
}

