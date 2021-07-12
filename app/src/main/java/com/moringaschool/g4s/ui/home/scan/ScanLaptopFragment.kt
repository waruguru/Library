package com.ekenya.android.g4saccesscsystem.ui.home.scan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ekenya.android.g4saccesscsystem.R
import com.ekenya.android.g4saccesscsystem.databinding.FragmentScanLaptopBinding


class ScanLaptopFragment : Fragment() {
    private lateinit var binding: FragmentScanLaptopBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScanLaptopBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Ivback.setOnClickListener {
            findNavController().navigate(R.id.visitorDetailsFragment)
        }

        binding.btnProceed2.setOnClickListener {
            findNavController().navigate(R.id.action_scanLaptopFragment_to_visitorSummaryFragment)
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            ScanLaptopFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}