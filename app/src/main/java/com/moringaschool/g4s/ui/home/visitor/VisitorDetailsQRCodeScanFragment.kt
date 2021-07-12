package com.ekenya.android.g4saccesscsystem.ui.home.visitor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ekenya.android.g4saccesscsystem.R


class VisitorDetailsQRCodeScanFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visitor_details_q_r_code_scan, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            VisitorDetailsQRCodeScanFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}