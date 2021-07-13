package com.moringa.android.g4saccesscsystem.ui.auth.login

import android.Manifest
import android.app.AlertDialog
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.databinding.FragmentBiometricLoginBinding


class BiometricLoginFragment : Fragment() {
    private lateinit var btnYes: Button
    private lateinit var btnNo: Button

    private var _binding: FragmentBiometricLoginBinding? = null
    private val binding get() = _binding!!




    /*private var cancellationSignal: CancellationSignal? = null
    private val authenticationCallback: BiometricPrompt.AuthenticationCallback*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBiometricLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        fingerprint()
        // Inflate the layout for this fragment
        return view
    }

    private fun fingerprint() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val fingerPrintManager = requireContext().getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager
            val keyguardManager = requireContext().getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            if (!fingerPrintManager.isHardwareDetected) {
                // hardware not detected
                Toast.makeText(context, "Hardware not detected", Toast.LENGTH_SHORT).show()
            } else if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                // permission ungranted
                //tvFingerPrintMessage.text = "Permission is not granted"
                Toast.makeText(context, "Fingerprint detected", Toast.LENGTH_SHORT).show()

            } else if (!keyguardManager.isKeyguardSecure) {
                // add key guard to your phone
                //tvFingerPrintMessage.text = "Please add your phone Key guard"
                Toast.makeText(context, "fingerprint Successfull", Toast.LENGTH_SHORT).show()

            } else if (!fingerPrintManager.hasEnrolledFingerprints()) {
                // you should add at least 1 fingerprint to use this feature
               // tvFingerPrintMessage.text = "You should add at least 1 fingerprint to use this feature"
            } else {
                // place your finger on scanner
                val fingerprintHandler = FingerPrintHandler(requireContext())
                fingerprintHandler.auth(fingerPrintManager, null) { message: String, isSuccess: Boolean ->
                    //tvFingerPrintMessage. = message
                    if (isSuccess) {
                       // Toast.makeText(context, "fingerprint success", Toast.LENGTH_SHORT).show()

                         binding.IvFingerPrint.setImageResource(R.drawable.ic_check)
                       //binding.tvSensor.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                        // shape.setColor(ContextCompat.getColor(context, R.color.green))
                       // btnNo.isEnabled = true
                       // btnYes.isEnabled = true
                    } else {
                       binding.IvFingerPrint.setImageResource(R.drawable.ic_priority_high)
                        binding.tvSensor.setTextColor(ContextCompat.getColor(requireContext(), R.color.Dark))
                        // shape.setColor(ContextCompat.getColor(context, R.color.Dark))
                    }
                    // ivFingerPrintIcon.background = shape

                }
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBiometricLogin.setOnClickListener {
            findNavController().navigate(R.id.action_biometricLoginFragment_to_verificationFragment)
        }

        binding.btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_biometricLoginFragment_to_dashBoardFragment)
        }

    }
    companion object {

        fun newInstance(param1: String, param2: String) =
            BiometricLoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}