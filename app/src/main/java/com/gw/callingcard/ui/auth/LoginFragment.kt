package com.gw.callingcard.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gw.callingcard.R
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.databinding.FragmentLoginBinding
import com.gw.callingcard.ui.base.BaseFragment


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding
            = FragmentLoginBinding.inflate(layoutInflater,container,false);

    override fun getFragmentRepository(): AuthRepository= AuthRepository(remoteDataSource.buildApi(APIInterface::class.java))

}