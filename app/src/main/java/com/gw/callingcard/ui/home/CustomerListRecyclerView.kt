package com.gw.callingcard.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gw.callingcard.data.responses.Customer
import com.gw.callingcard.databinding.CustomerItemviewLayoutBinding

class CustomerListRecyclerView(var customerList: List<Customer> ) : RecyclerView.Adapter<CustomerListRecyclerView.ViewHolder>() {

   //Step 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= CustomerItemviewLayoutBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //No need to use
        //holder.binding.customerDescriptionTv  .text=customerlist[position].customer_description.toString()
        with(holder){
            with(customerList[position]){
                binding.customerDescriptionTv.text=customer_description?.let {
                    customer_description.   toString()
                }
                binding.customerNameTv.text=customer_name.toString()
                binding.customerNumberTv.text=customer_mobile.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return customerList.size
    }



//Step 1
    // once the listitem of the Recyclerview is set, the we will get itemView binding class generated..
  inner  class ViewHolder(val binding: CustomerItemviewLayoutBinding): RecyclerView.ViewHolder(binding.root){}

}