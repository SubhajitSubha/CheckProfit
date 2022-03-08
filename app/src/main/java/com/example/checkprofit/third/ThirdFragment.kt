package com.example.checkprofit.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.checkprofit.R
import com.example.checkprofit.databinding.FragmentThirdBinding
import com.example.checkprofit.second.SecondViewModel


class ThirdFragment : Fragment() {
   //private lateinit var binding:FragmentThirdBinding
    private lateinit var viewModel:SecondViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.run {
            ViewModelProvider(this).get(SecondViewModel::class.java)
        }!!
        // Inflate the layout for this fragment
        val binding:FragmentThirdBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_third, container, false)
        viewModel.ans.observe(this, Observer { newResult->
            binding.result.text = newResult
        })
        binding.doAgain.setOnClickListener{
            findNavController().navigate((R.id.action_thirdFragment2_to_SecondFragment))

        }

        binding.goHome.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment2_to_FirstFragment)
        }
        return binding.root
    }



}