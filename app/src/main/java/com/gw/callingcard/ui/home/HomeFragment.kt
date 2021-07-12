package com.gw.callingcard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gw.callingcard.R
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.data.repository.HomeRepository
import com.gw.callingcard.databinding.FragmentHomeBinding
import com.gw.callingcard.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, HomeRepository>() {




    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater, container, false)

    override fun getFragmentRepository(): HomeRepository =  HomeRepository(remoteDataSource.buildApi(
        APIInterface::class.java),appPreferences)


}