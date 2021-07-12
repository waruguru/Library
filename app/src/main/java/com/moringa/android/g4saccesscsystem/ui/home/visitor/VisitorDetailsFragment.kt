package com.moringa.android.g4saccesscsystem.ui.home.visitor

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.fragment.findNavController
import com.moringa.android.g4saccesscsystem.CanvasCapture
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.databinding.FragmentVisitorDetailsBinding


class VisitorDetailsFragment : Fragment(), CanvasCapture.SurfaceCanvasCallBack {
    private  var _binding: FragmentVisitorDetailsBinding? = null
    private val binding get() = _binding!!

    var currentLayout = 1
    private var isCardSelected = 0
    private lateinit var canvasCapture: CanvasCapture
    var captureArea: View? = null
    var signature: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVisitorDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        showLayoutOne()
        showLayoutTwo()
        showSignature()

        return view
    }

    private fun showLayoutOne() {
        currentLayout = 1
        binding.layout1.visibility = View.VISIBLE
        binding.layout2.visibility = View.GONE
        binding.btnContinue.setText("NEXT")
        binding.tvBtnOne.background = resources.getDrawable(R.drawable.selected_drawable)
        binding.tvBtnTwo.background = resources.getDrawable(R.drawable.unselected_background)
        binding.v1.setBackgroundColor(resources.getColor(R.color.ColorRed))

    }

    private fun showLayoutTwo() {
        currentLayout = 2
        binding.layout2.visibility = View.VISIBLE
        binding.layout1.visibility = View.GONE
        binding.btnContinue.setText("CONTINUE")
        binding.tvBtnOne.background = resources.getDrawable(R.drawable.selected_drawable)
        binding.tvBtnTwo.background = resources.getDrawable(R.drawable.selected_drawable)
        binding.v1.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun showSignature() {
       val signatureLayout = binding.clSignature
        val set = ConstraintSet()

        canvasCapture = CanvasCapture(this.requireContext(), null, this,signatureLayout)
        signatureLayout.addView(canvasCapture, 0)
        canvasCapture!!.setId(View.generateViewId())

        set.clone(signatureLayout)
        set.connect(
            canvasCapture!!.id,
            ConstraintSet.TOP,
            signatureLayout.getId(),
            ConstraintSet.TOP,
            0
        )

        set.applyTo(signatureLayout)
        signatureLayout.isDrawingCacheEnabled
        captureArea = signatureLayout
        val imgEraser = binding.imgEraser
        imgEraser.setOnClickListener(View.OnClickListener { v: View? -> canvasCapture.clear() })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvBtnOne.setOnClickListener {
            showLayoutOne()
        }

        binding.tvBtnTwo.setOnClickListener {
            showLayoutTwo()
        }


        binding.IvBackArrow.setOnClickListener {
            findNavController().navigate(R.id.scanIdFragment)
        }

        binding.btnContinue.setOnClickListener {
            when (currentLayout) {
                1 -> {
                    binding.btnContinue.setText("NEXT")
                    showLayoutTwo()
                }
                2 ->{
                    binding.btnContinue.setText("CONTINUE")
                    findNavController().navigate(R.id.scanLaptopFragment)
                }
            }
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            VisitorDetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCaptureCallBack(base64Image: String?, bitmapImage: Bitmap?, view: View?) {
        TODO("Not yet implemented")
    }
}