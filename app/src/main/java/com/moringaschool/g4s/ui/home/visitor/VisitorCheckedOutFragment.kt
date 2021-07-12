package com.ekenya.android.g4saccesscsystem.ui.home.visitor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ekenya.android.g4saccesscsystem.R
import com.ekenya.android.g4saccesscsystem.databinding.FragmentVisitorCheckedOutBinding

class VisitorCheckedOutFragment : Fragment() {
    private lateinit var binding: FragmentVisitorCheckedOutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVisitorCheckedOutBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBackHome.setOnClickListener {
            findNavController().navigate(R.id.action_visitorCheckedOutFragment_to_scanVisitorDetailsFragment)
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            VisitorCheckedOutFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}