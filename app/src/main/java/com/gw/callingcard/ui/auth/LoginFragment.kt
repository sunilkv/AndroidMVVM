package com.gw.callingcard.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.databinding.FragmentLoginBinding
import com.gw.callingcard.ui.base.BaseFragment


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
       // super.onActivityCreated(savedInstanceState)

        //observe the login response..
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
              is   Resource.Success ->{
                    Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                }
                is Resource.Failure ->{
                    Toast.makeText(requireContext(), "Login failure", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.buttonLogin.setOnClickListener{
            val email=binding.editTextTextEmailAddress.text.toString().trim()
            val password=binding.editTextTextPassword.text.toString().trim()
            //@todo add validations.
            viewModel.login(email,password)

        }

    }

    //Setting up the View Model
    override fun getViewModel() = AuthViewModel::class.java

    //Setting up the Databinding
    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding
            = FragmentLoginBinding.inflate(layoutInflater,container,false);
  //Setting up the Repository

    override fun getFragmentRepository(): AuthRepository= AuthRepository(remoteDataSource.buildApi(APIInterface::class.java))

}