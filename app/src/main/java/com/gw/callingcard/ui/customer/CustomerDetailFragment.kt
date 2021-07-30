package com.gw.callingcard.ui.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gw.callingcard.data.repository.CustomerDetailRepository
import com.gw.callingcard.databinding.FragmentCustomerDetailBinding
import com.gw.callingcard.ui.base.BaseFragment


class CustomerDetailFragment : BaseFragment<CustomerDetailViewModel, FragmentCustomerDetailBinding, CustomerDetailRepository>() {




    override fun getViewModel(): Class<CustomerDetailViewModel> {
        TODO("Not yet implemented")
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCustomerDetailBinding {
        TODO("Not yet implemented")
    }

    override fun getFragmentRepository(): CustomerDetailRepository {
        TODO("Not yet implemented")
    }
}

