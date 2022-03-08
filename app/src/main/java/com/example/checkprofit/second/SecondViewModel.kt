package com.example.checkprofit.second

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.checkprofit.R

class SecondViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var inputPrice = MutableLiveData<String>()

    //val inputPrice: MutableLiveData<String>
    //get() = _inputPrice
    var inputPercentage = MutableLiveData<String>()
    private val _ans = MutableLiveData<String>()
    val ans :LiveData<String>
    get() = _ans
    //private val price1: Double= inputPrice.value.toDouble()
    //private val percentage1: Double? = inputPercentage.value?.toDouble()
    fun calculate(){
        Log.v("calculator","fun called")
        Log.d("calculator","${inputPrice.value}")
        Log.v("calculator","${inputPrice.value.toString()}...${inputPercentage.value.toString()}")
        if(inputPrice.value.isNullOrBlank()||inputPercentage.value.isNullOrBlank()){
            _ans.value = ""
        }else {

            _ans.value = add(inputPrice.value.toString(), inputPercentage.value.toString())
            Log.v("calculator", "${_ans.value}")
        }
    }
    fun add(price:String,percentage:String): String {
        val result3 = price.toDouble().plus(price.toDouble()*(percentage.toDouble().div(100)))
        return result3.toString()
    }

}