package com.gw.callingcard.data.responses

data class EmployeeDashboardResponse(
    val `data`: Data
){
    data class Data( val Customers: List<Customer>,
                     val FollowupCustomers: Int,
                     val NewCustomer: Int,
                     val TaskCount: Int,
                     val TotalDeals: Int)
}

