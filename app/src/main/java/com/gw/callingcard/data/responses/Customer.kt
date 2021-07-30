package com.gw.callingcard.data.responses

data class Customer(
    val CustomerID: String,
    val add_address: String,
    val add_description: String,
    val add_pincode: String,
    val city_name: String,
    val customer_created_at: String,
    val customer_description: Any,
    val customer_email: String,
    val customer_mobile: String,
    val customer_name: String,
    val partner_name: String,
    val state_name: String
)