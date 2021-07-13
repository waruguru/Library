package com.moringa.android.g4saccesscsystem.ui.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.databinding.FragmentCheckedInBinding

class CheckedInFragment : Fragment() {
    private var _binding: FragmentCheckedInBinding? = null
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

        _binding = FragmentCheckedInBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackHome.setOnClickListener {
            findNavController().navigate(R.id.action_checkedInFragment_to_summaryFragment)
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            CheckedInFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}