package com.moringa.android.g4saccesscsystem.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.databinding.FragmentLoginInputBinding

class LoginInputFragment : Fragment() {

    private lateinit var binding: FragmentLoginInputBinding;
    private val PIN_MASKING_CHAR = "✽"
    val passwordToggle=0

     //the pin inputs
    private var one1: String? = null
    private var two2: String? = null
    private var three3: String? = null
    private var four4: String? = null
    private var mConfirmPin: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginInputBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        binding.apply {
            binding.btn1.setOnClickListener { controlPinPad2("1") }
            binding.btn2.setOnClickListener { controlPinPad2("2") }
            binding.btn3.setOnClickListener { controlPinPad2("3") }
            binding.btn4.setOnClickListener { controlPinPad2("4") }
            binding.btn5.setOnClickListener { controlPinPad2("5") }
            binding.btn6.setOnClickListener { controlPinPad2("6") }
            binding.btn7.setOnClickListener { controlPinPad2("7") }
            binding.btn8.setOnClickListener { controlPinPad2("8") }
            binding.btn9.setOnClickListener { controlPinPad2("9") }
            binding.btn0.setOnClickListener { controlPinPad2("0")}
            binding.btnBackSpace1.setOnClickListener { deletePinEntry() }
           // btnShow.setOnClickListener { showPassword() }

        }

        return (binding.root)
    }

    private fun controlPinPad2(entry: String) {
        binding.apply {
            if (one1 == null) {
                one1 = entry
                binding.etOne.setText(PIN_MASKING_CHAR)
            } else if (two2 == null) {
                two2 = entry
                binding.etTwo.setText(PIN_MASKING_CHAR)
            } else if (three3 == null) {
                three3 = entry
                binding.etThree.setText(PIN_MASKING_CHAR)
            } else if (four4 == null) {
                four4 = entry
                binding.etFour.setText(PIN_MASKING_CHAR)

            }
            if (mConfirmPin == null) {
                mConfirmPin = entry
            } else {
                mConfirmPin = mConfirmPin + entry
            }
             if (mConfirmPin!!.length == 4) {
                 binding.btnLogin.isEnabled = true
             }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.tvLogin.

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginInputFragment_to_home)
        }
    }

    private fun deletePinEntry() {
        binding.apply {
            if (mConfirmPin != null && mConfirmPin!!.length > 0) {
                mConfirmPin = mConfirmPin!!.substring(0, mConfirmPin!!.length - 1)
            }
            if (four4 != null) {
                binding.etFour.setText("")
                four4 = null
            } else if (three3 != null) {
                binding.etThree.setText("")
                three3 = null
            } else if (two2 != null) {
                binding.etTwo.setText("")
                two2 = null
            } else if (one1 != null) {
                binding.etOne.setText("")
                one1 = null
            }
        }

    }

    private fun showPassword(){

    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            LoginInputFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}