package com.ekenya.android.g4saccesscsystem.ui.home.scan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ekenya.android.g4saccesscsystem.R
import com.ekenya.android.g4saccesscsystem.databinding.FragmentQRCodeBinding


class QRCodeFragment : Fragment() {
    private var _binding: FragmentQRCodeBinding? = null
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
        _binding = FragmentQRCodeBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.IvLeftArrow.setOnClickListener {
            findNavController().navigate(R.id.visitorSummaryFragment)
        }

        binding.btnPrint.setOnClickListener {
            findNavController().navigate(R.id.action_QRCodeFragment_to_checkedInFragment)
        }

        binding.IvShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT, "https://help.linktr.ee/en/support/solutions/articles/48001153058-download-your-qr-code"
            )
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }



    companion object {

        fun newInstance(param1: String, param2: String) =
            QRCodeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}