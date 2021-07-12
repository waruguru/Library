package com.ekenya.android.g4saccesscsystem.ui.home.scan

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ekenya.android.g4saccesscsystem.R
import com.ekenya.android.g4saccesscsystem.databinding.FragmentScanIdBinding
import com.ekenya.rnd.scannerlib.ScannerInterface
import com.ekenya.rnd.scannerlib.ScannerInterfaceImp
import com.ekenya.rnd.scannerlib.models.IdScanResult


class ScanIdFragment : Fragment() {
    private lateinit var binding: FragmentScanIdBinding

    private var ivCardImg: ImageView? = null
    private var ivUserImg: ImageView? = null

    //hide fields
    private var tvInstr: TextView? = null
    private var ivFacePrev: ImageView? = null
    private var ivCardPrev: ImageView? = null

    private var captureOption = ""
    private val isCard = true
    private val cardType = ""

    private var cardBitmap: Bitmap? = null
    private var faceBitmap: Bitmap? = null

    private val scannerInterfaceImp: ScannerInterfaceImp = ScannerInterfaceImp()

    private val cardResultsCallback: ScannerInterfaceImp.CardResults = object : ScannerInterfaceImp.CardResults {
        override fun onCardResult(scanResult: IdScanResult?) {
            if (scanResult != null) {
               ivCardPrev!!.visibility = View.GONE
                ivCardImg!!.setImageBitmap(scanResult.getFace())
                cardBitmap = scanResult.getFace()
              //  extractData(scanResult.getDetails())
            }
        }

        override fun onCardFailure(error: String?) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    private val livenessResultsCallback: ScannerInterfaceImp.LivenessResults =
        object : ScannerInterfaceImp.LivenessResults {
            override fun isLive(result: Boolean) {
                if (result) Toast.makeText(context, "Face is live", Toast.LENGTH_SHORT).show()
                else Toast.makeText(context, "Face is not live", Toast.LENGTH_LONG).show()
            }

            override fun checkFailed(error: String?) {
                Toast.makeText(context, "Liveness check has failed $ error", Toast.LENGTH_LONG).show()
            }

            override fun faceImage(face: Bitmap?) {
                ivFacePrev!!.visibility = View.GONE
                tvInstr!!.visibility = View.GONE
                ivUserImg!!.setImageBitmap(face)
                faceBitmap = face
            }
        }

    private val verificationScoreCallback: ScannerInterfaceImp.VerificationScore =
        object : ScannerInterfaceImp.VerificationScore {
            override fun matchScore(result: Float) {
                showResultDialog(result)
            }

            override fun matchFailed(error: String?) {
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            }
        }

    private fun showResultDialog(similarity: Float) {
        AlertDialog.Builder(context)
            .setTitle("Verification Results")
            .setMessage("Similarity score is: $similarity")
            .setIcon(R.drawable.ic_info)
            .setPositiveButton(
                "CLOSE"
            ) { dialog: DialogInterface, id: Int -> dialog.cancel() }.show()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // Check for camera permission otherwise initialise application



        }
    }

    private fun initUI() {
        binding.tvScanID.setOnClickListener {
           scannerInterfaceImp.scanIdCard(requireContext(), ScannerInterface.CardType.IDCARD, cardResultsCallback)
            Toast.makeText(context, "ScanId", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScanIdBinding.inflate(layoutInflater)

        if (ActivityCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) requestCameraPermission()

        initUI()
        return binding.root

    }

    private fun requestCameraPermission() {
        val permissions = arrayOf(android.Manifest.permission.CAMERA)
        if (!ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), android.Manifest.permission.CAMERA)
        ) {
            val CAMERA_PERMISSION = 111
            ActivityCompat.requestPermissions(requireActivity(), permissions, CAMERA_PERMISSION )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != 111) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            return
        }
        if (grantResults.size !=0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "You won't be able to access the functionality", Toast.LENGTH_LONG).show()
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Ivback.setOnClickListener {
            findNavController().navigate(R.id.home)
        }

        binding.btnProceed.setOnClickListener {
            findNavController().navigate(R.id.action_scanIdFragment_to_visitorDetailsFragment)
        }
    }


    companion object {

        fun newInstance(param1: String, param2: String) =
            ScanIdFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}