package com.moringa.android.g4saccesscsystem.ui.home.visitor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.databinding.FragmentVisitorSummaryBinding


class VisitorSummaryFragment : Fragment() {
    private var _binding: FragmentVisitorSummaryBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVisitorSummaryBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.IvLeftArrow.setOnClickListener {
            findNavController().navigate(R.id.scanLaptopFragment)
        }

        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.action_visitorSummaryFragment_to_QRCodeFragment)
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            VisitorSummaryFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}