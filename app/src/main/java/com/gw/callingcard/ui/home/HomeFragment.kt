package com.gw.callingcard.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gw.callingcard.data.network.APIInterface
import com.gw.callingcard.data.network.Resource
import com.gw.callingcard.data.repository.HomeRepository
import com.gw.callingcard.databinding.FragmentHomeBinding
import com.gw.callingcard.ui.base.BaseFragment
import com.gw.callingcard.ui.handleApiError
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, HomeRepository>() {


    lateinit var linearLayoutManager: LinearLayoutManager
     lateinit var rvAdapter: CustomerListRecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {
        lifecycleScope.launch {
            binding.username.text = getFragmentRepository().getAuthToken()

        }
        //Calling the API
        viewModel.getEmployeeDashboard("2")

        viewModel.employeeDashboardResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    if (it.value.data != null) {
                        binding.todaysTv.text = it.value.data.TaskCount.toString()
                        binding.followupTv.text = it.value.data.FollowupCustomers.toString()
                        binding.dealTv.text = it.value.data.TotalDeals.toString()
                        binding.rejectedTv.text = it.value.data.NewCustomer.toString()
                        //Here Plan for Recycler View..
                        linearLayoutManager = LinearLayoutManager(context)
                        binding.recyclerviewRv.layoutManager=linearLayoutManager
                        //Set Adapter..
                        rvAdapter=CustomerListRecyclerView(it.value.data.Customers)
                        binding.recyclerviewRv.adapter=rvAdapter

                    }
                }
                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        })
    }


    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater, container, false)

    override fun getFragmentRepository(): HomeRepository = HomeRepository(
        remoteDataSource.buildApi(
            APIInterface::class.java
        ), appPreferences
    )

}