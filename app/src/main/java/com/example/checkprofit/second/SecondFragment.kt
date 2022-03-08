package com.example.checkprofit.second

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.checkprofit.R
import com.example.checkprofit.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {


    private lateinit var binding: FragmentSecondBinding
    private lateinit var vm: SecondViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this).get(SecondViewModel::class.java)
        }!!
        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)
        binding.mainViewModel = vm



        //val editTextPrice = binding.price.text
        //viewModel.inputPrice.value = binding.price.text.toString()
//        viewModel._inputPrice.observe(this, Observer {  newPrice->
//            binding.price.text = newPrice.toEditable()
//        })

        //viewModel.inputPercentage.value = binding.percentage.text.toString()
        binding.buttonSecond.setOnClickListener {
            addPrice()
            addPercentage()
            vm.calculate()
            Log.v("viewmodel","${binding.price.text.toString()}")
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment2)
            vm.inputPrice.value = ""
            vm.inputPercentage.value = ""
        }


        binding.goHome1.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        return binding.root


    }
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

   fun addPrice(){

       var editPrice = binding.price
       var thingPrice = editPrice.text.toString()
       if(thingPrice.isNullOrBlank()){
           Toast.makeText(context,"provide correct value",Toast.LENGTH_SHORT).show()
       }
       else{
           vm.inputPrice.value = thingPrice
           Log.v("function","AddPrice called")
       }

   }
    fun addPercentage(){

        var editPercentage = binding.percentage
        var thingPercentage = editPercentage.text.toString()
        if(thingPercentage.isNullOrBlank()){
            Toast.makeText(context,"provide correct value",Toast.LENGTH_SHORT).show()
        }
        else{
            vm.inputPercentage.value = thingPercentage
            Log.v("function","AddPrice called")
        }

    }

}