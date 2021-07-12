package com.moringa.android.g4saccesscsystem.ui.auth.login

import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.moringa.android.g4saccesscsystem.databinding.FragmentLoginBinding
import java.security.KeyStore
import javax.crypto.Cipher
import kotlin.jvm.internal.Intrinsics
import kotlin.reflect.KParameter

//@Metadata(
//    mv = [1, 4, 3],
//    bv = [1, 0, 3],
//    k = 1,
//    d1 = ["\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("],
//    d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/auth/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "KEY_NAME", "", "_binding", "Lcom/moringa/android/g4saccesscsystem/databinding/FragmentLoginBinding;", "binding", "getBinding", "()Lcom/moringa/android/g4saccesscsystem/databinding/FragmentLoginBinding;", "btnNo", "Landroid/widget/Button;", "btnYes", "button", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "cipher", "Ljavax/crypto/Cipher;", "keyStore", "Ljava/security/KeyStore;", "onCancelClicked", "Lkotlin/Function0;", "", "onNoClicked", "onYesClicked", "getSystemService", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "G4S_Access_C_System.app"]
//)
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    var button: Button? = null
    private val onYesClicked: Function0<*>
    private val onNoClicked: Function0<*>
    private val onCancelClicked: Function0<*>
    private val btnYes: Button? = null
    private val btnNo: Button? = null
    private val keyStore: KeyStore? = null
    private val cipher: Cipher? = null
    private val KEY_NAME: String
    private val binding: FragmentLoginBinding?
        private get() {
            val var10000 = _binding
            Intrinsics.checkNotNull(var10000)
            return var10000
        }

    fun getButton(): Button {
        val var10000 = button
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button")
        }
        return var10000!!
    }

    fun setButton(var1: Button) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>")
        button = var1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this.arguments != null) {
            val var3 = false
            val var4 = false
            val var6 = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Intrinsics.checkNotNullParameter(inflater, "inflater")
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val var10000 = binding!!.root
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root")
        val view = var10000
        binding!!.btnBiometricLogin.setOnClickListener(View.OnClickListener {
            if (Build.VERSION.SDK_INT >= 23) {
                val var10000 = this@LoginFragment.context
                val var3 = var10000?.getSystemService("fingerprint")
                    ?: throw NullPointerException("null cannot be cast to non-null type android.hardware.fingerprint.FingerprintManager")
                val fingerPrintManager = var3 as FingerprintManager
                if (fingerPrintManager.isHardwareDetected && fingerPrintManager.hasEnrolledFingerprints()) {
                    val var10002 = requireContext()
                    Intrinsics.checkNotNullExpressionValue(var10002, "this.requireContext()")
                    FingerPrintDialog(var10002).setCallback(
                        (KParameter.Kind.INSTANCE as Function0<*>?)!!,
                        (KParameter.Kind.INSTANCE as Function0<*>?)!!, (KParameter.Kind.INSTANCE as Function0<*>?)!!
                    ).build().show()
                } else {
                    Toast.makeText(
                        this@LoginFragment.context,
                        "Hardware not detected" as CharSequence,
                        0
                    ).show()
                }
            } else {
                Toast.makeText(
                    this@LoginFragment.context,
                    "Need Android minimum version Marshmellow for this feature" as CharSequence,
                    0
                ).show()
            }
        })
        return view
    }

    private val systemService: Unit
        private get() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Intrinsics.checkNotNullParameter(view, "view")
        super.onViewCreated(view, savedInstanceState)
        binding!!.btnBiometricLogin.setOnClickListener(View.OnClickListener {
            this@LoginFragment.findNavController().navigate(1000457)
        })
        binding!!.btnLogin.setOnClickListener(View.OnClickListener {
            this@LoginFragment.findNavController().navigate(1000001)
        })
    }

//    @Metadata(
//        mv = [1, 4, 3],
//        bv = [1, 0, 3],
//        k = 1,
//        d1 = ["\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"],
//        d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/auth/login/LoginFragment\$Companion;", "", "()V", "newInstance", "Lcom/moringa/android/g4saccesscsystem/ui/auth/login/LoginFragment;", "param1", "", "param2", "G4S_Access_C_System.app"]
//    )
    class Companion private constructor() {
        fun newInstance(param1: String, param2: String): LoginFragment {
            Intrinsics.checkNotNullParameter(param1, "param1")
            Intrinsics.checkNotNullParameter(param2, "param2")
            val var3 = LoginFragment()
            val var4 = false
            val var5 = false
            val var7: Int = false.toInt()
            val var8 = Bundle()
            val var9 = false
            val var10 = false
            val var13 = false
            val var14 = Unit
            var3.arguments = var8
            return var3
        }

        // $FF: synthetic method
        constructor(`$constructor_marker`: DefaultConstructorMarker?) : this() {}
    }

    companion object {
        val Companion = Companion(null as DefaultConstructorMarker?)
    }

    init {
        onYesClicked = KParameter.Kind.INSTANCE as Function0<*>
        onNoClicked = KParameter.Kind.INSTANCE as Function0<*>
        onCancelClicked = KParameter.Kind.INSTANCE as Function0<*>
        KEY_NAME = "AndroidKey"
    }
}