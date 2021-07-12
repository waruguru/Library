package com.moringa.android.g4saccesscsystem.ui.auth.login

import android.content.Context
import android.hardware.fingerprint.FingerprintManager
import android.os.CancellationSignal
import android.os.Handler
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlin.jvm.internal.Intrinsics

@Metadata(
    mv = [1, 4, 3],
    bv = [1, 0, 3],
    k = 1,
    d1 = ["\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u001228\b\u0002\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"],
    d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/auth/login/FingerPrintHandler;", "Landroid/hardware/fingerprint/FingerprintManager\$AuthenticationCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "message", "", "isSuccess", "", "auth", "fingerPrintManager", "Landroid/hardware/fingerprint/FingerprintManager;", "cryptoObject", "Landroid/hardware/fingerprint/FingerprintManager\$CryptoObject;", "onAuthenticationFailed", "onAuthenticationSucceeded", "result", "Landroid/hardware/fingerprint/FingerprintManager\$AuthenticationResult;", "G4S_Access_C_System.app"]
)
@RequiresApi(23)
class FingerPrintHandler(context: Context) :
    FingerprintManager.AuthenticationCallback() {
    private var callback: Function2<*, *, *>
    private val context: Context
    fun auth(
        fingerPrintManager: FingerprintManager,
        cryptoObject: FingerprintManager.CryptoObject?,
        callback: Function2<*, *, *>
    ) {
        Intrinsics.checkNotNullParameter(fingerPrintManager, "fingerPrintManager")
        Intrinsics.checkNotNullParameter(callback, "callback")
        val cancellationSignal = CancellationSignal()
        fingerPrintManager.authenticate(
            cryptoObject, cancellationSignal, 0,
            (this as FingerprintManager.AuthenticationCallback), null as Handler?
        )
        this.callback = callback
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        callback.invoke("Fingerprint not recognized. Try again", false)
        Toast.makeText(context, "Fingerprint not recognized. Try again" as CharSequence, 1).show()
    }

    override fun onAuthenticationSucceeded(result: FingerprintManager.AuthenticationResult?) {
        super.onAuthenticationSucceeded(result)
        callback.invoke("Fingerprint recognized", true)
        Toast.makeText(context, "Fingerprint recognized." as CharSequence, 1).show()
    }

    companion object {
        // $FF: synthetic method
        fun `auth$default`(
            var0: FingerPrintHandler,
            var1: FingerprintManager,
            var2: FingerprintManager.CryptoObject?,
            var3: Function2<*, *, *>,
            var4: Int,
            var5: Any?
        ) {
            var var3 = var3
            if (var4 and 4 != 0) {
                var3 = null.INSTANCE as Function2<*, *, *>
            }
            var0.auth(var1, var2, var3)
        }
    }

    init {
        Intrinsics.checkNotNullParameter(context, "context")
        super()
        this.context = context
        callback = null.INSTANCE as Function2<*, *, *>
    }
}