package com.moringa.android.g4saccesscsystem.ui.home.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.adapter.PhonedetailsAdapter
import com.moringa.android.g4saccesscsystem.databinding.FragmentDashBoardBinding
import com.moringa.android.g4saccesscsystem.model.Phonedetails

class DashBoardFragment : Fragment() {
    private var _binding: FragmentDashBoardBinding? = null
    private val binding get() = _binding!!
    lateinit var items : ArrayList<Phonedetails>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashBoardBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

        items = ArrayList()
        addMoreItems()
        val cycle=binding.rvRecyclerview
        cycle.layoutManager= LinearLayoutManager(requireContext())
        cycle.adapter= context?.let { PhonedetailsAdapter(it,items) }
        return view
    }

    private fun addMoreItems() {
        items.add(Phonedetails(R.drawable.ic_call_received, "Name", "Office", "Simon Kimani", "Eclectics", "ID: 23647564", "Today 8:03 am"))
        items.add(Phonedetails(R.drawable.ic_baseline_call_made_24, "Name", "Office", "Simon Kimani", "Eclectics", "ID: 23647564", "Today 8:03 am"))
        items.add(Phonedetails(R.drawable.ic_call_received, "Name", "Office", "Simon Kimani", "Eclectics", "ID: 23647564", "Today 8:03 am"))
       // items.add(Phonedetails(R.drawable.ic_baseline_call_made_24, "Name", "Office", "Simon Kimani", "Eclectics", "ID: 23647564", "Today 8:03 am"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheckIn.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_scanIdFragment)
        }


    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}