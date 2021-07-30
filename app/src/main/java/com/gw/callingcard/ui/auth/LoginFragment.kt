package com.gw.callingcard.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.gw.callingcard.R
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.databinding.FragmentLoginBinding
import com.gw.callingcard.ui.*
import com.gw.callingcard.ui.base.BaseFragment
import com.gw.callingcard.ui.home.DashboardActivity
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.enable(false)
        //observe the login response..
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressbar.visible(false)
            when(it){
                is   Resource.Success ->{
                    //using lifecycle scope because preferences will take time to store before that the activity will get started..
                    if(it.value.success) {
                        lifecycleScope.launch {
                            viewModel.saveAuthToken(it.value.data.phonenumber.toString())
                            requireActivity().startNewActivity(DashboardActivity::class.java)
                        }
                    }else{
                        requireView().snackbar(it.value.message)
                    }
                }
                is Resource.Failure ->{
                    handleApiError(it)
                }
            }
        })

        binding.buttonLogin.setOnClickListener{
            login()
        }

        binding.textViewRegisterNow.setOnClickListener(
            Navigation.createNavigateOnClickListener
                (R.id.action_loginFragment_to_signupFragment3)
        )

        binding.editTextTextPassword.addTextChangedListener {
            val email= binding.editTextTextEmailAddress.text.toString().trim()
            binding.buttonLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }
    }

    private fun login() {
        val email = binding.editTextTextEmailAddress.text.toString().trim()
        val password = binding.editTextTextPassword.text.toString().trim()
                binding.progressbar.visible(true)
                viewModel.login(email,password)
        }




    //Setting up the View Model
    override fun getViewModel() = AuthViewModel::class.java

    //Setting up the Databinding
    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding
                    = FragmentLoginBinding.inflate(layoutInflater,container,false)

    //Setting up the Repository
    override fun getFragmentRepository(): AuthRepository= AuthRepository(remoteDataSource.buildApi(APIInterface::class.java),appPreferences)

}




