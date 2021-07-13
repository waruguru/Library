package com.moringa.android.g4saccesscsystem.ui.auth.login

import android.Manifest
import android.app.AlertDialog
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
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
import com.moringa.android.g4saccesscsystem.databinding.FragmentLoginBinding
import java.security.KeyStore
import javax.crypto.Cipher


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    lateinit var button: Button

    private var onYesClicked: () -> Unit = {}
    private var onNoClicked: () -> Unit = {}
    private var onCancelClicked: () -> Unit = {}

    private lateinit var btnYes: Button
    private lateinit var btnNo: Button

    private lateinit var keyStore: KeyStore
    private lateinit var cipher: Cipher
    private var KEY_NAME = "AndroidKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnBiometricLogin.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
               // val fingerPrintManager = applicationcontext.getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager
                   val fingerPrintManager = this.context?.getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager
                if (!fingerPrintManager.isHardwareDetected || !fingerPrintManager.hasEnrolledFingerprints()) {
                    Toast.makeText(this.context,"Hardware not detected", Toast.LENGTH_SHORT).show()
                }else{
                    FingerPrintDialog(SettingActivity@ this.requireContext())
                        .setCallback(
                            onYesClicked = {},
                            onNoClicked = {},
                            onCancelClicked = {}
                        )
                        .build().show()
                }
            }else{
                Toast.makeText(this.context,"Need Android minimum version Marshmellow for this feature", Toast.LENGTH_SHORT).show()
            }
        }


        return view
    }

    private fun getSystemService() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBiometricLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_biometricLoginFragment)
        }

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_loginInputFragment)
        }

    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}