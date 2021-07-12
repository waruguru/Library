package com.ekenya.android.g4saccesscsystem.ui.auth.login

import android.content.Context
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.os.CancellationSignal
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class FingerPrintHandler (private val context: Context) : FingerprintManager.AuthenticationCallback() {
    private var callback: (message: String, isSuccess: Boolean) -> Unit = { _, _ -> }
    fun auth(fingerPrintManager: FingerprintManager, cryptoObject: FingerprintManager.CryptoObject?, callback: (message: String, isSuccess: Boolean) -> Unit = { _, _ -> }) {
        val cancellationSignal = CancellationSignal()
        fingerPrintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null)
        this.callback = callback
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        callback("Fingerprint not recognized. Try again",false)
        Toast.makeText(context, "Fingerprint not recognized. Try again", Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult?) {
        super.onAuthenticationSucceeded(result)
        callback("Fingerprint recognized",true)
        Toast.makeText(context, "Fingerprint recognized.", Toast.LENGTH_LONG).show()

    }
}