package com.gw.callingcard.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.repository.CustomerDetailRepository
import com.gw.callingcard.databinding.FragmentCustomerDetailBinding
import com.gw.callingcard.ui.base.BaseFragment


class CustomerDetailFragment : BaseFragment<CustomerDetailViewModel, FragmentCustomerDetailBinding, CustomerDetailRepository>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun getViewModel(): Class<CustomerDetailViewModel> = CustomerDetailViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCustomerDetailBinding = FragmentCustomerDetailBinding.inflate(inflater,container,false)

    override fun getFragmentRepository(): CustomerDetailRepository = CustomerDetailRepository(remoteDataSource.buildApi(
        APIInterface::class.java),appPreferences)
}

