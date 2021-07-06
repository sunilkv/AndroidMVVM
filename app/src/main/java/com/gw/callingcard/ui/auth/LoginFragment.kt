package com.gw.callingcard.ui.auth

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.gw.callingcard.R
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.AuthRepository
import com.gw.callingcard.databinding.FragmentLoginBinding
import com.gw.callingcard.ui.base.BaseFragment
import com.gw.callingcard.ui.enable
import com.gw.callingcard.ui.home.HomeActivity
import com.gw.callingcard.ui.startNewActivity
import com.gw.callingcard.ui.visible
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.enable(false)
        //observe the login response..
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressbar.visible(false)
            when(it){
                is   Resource.Success ->{
                    viewModel.saveAuthToken(it.value.user.access_token.toString())
                    requireActivity().startNewActivity(HomeActivity::class.java)
                  //  Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                }
                is Resource.Failure ->{
                    Toast.makeText(requireContext(), "Invalid Login Credentials", Toast.LENGTH_LONG).show()
                }
            }
        })

        binding.buttonLogin.setOnClickListener{
            //TODO: Add validation Here
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




