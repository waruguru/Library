package com.moringa.android.g4saccesscsystem.ui.auth.login

import android.annotation.TargetApi
import android.app.AlertDialog
import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyPermanentlyInvalidatedException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.spec.AlgorithmParameterSpec
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.NoSuchPaddingException
import javax.crypto.SecretKey
import kotlin.jvm.internal.Intrinsics

//@Metadata(
//    mv = [1, 4, 3],
//    bv = [1, 0, 3],
//    k = 1,
//    d1 = ["\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0010H\u0003J6\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"],
//    d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/auth/login/FingerPrintDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "KEY_NAME", "", "btnNo", "Landroid/widget/Button;", "btnYes", "cipher", "Ljavax/crypto/Cipher;", "keyStore", "Ljava/security/KeyStore;", "onCancelClicked", "Lkotlin/Function0;", "", "onNoClicked", "onYesClicked", "build", "Landroid/app/AlertDialog;", "cipherInit", "", "generateKey", "setCallback", "G4S_Access_C_System.app"]
//)
class FingerPrintDialog(context: Context) {
    private var onYesClicked: Function0<*>
    private var onNoClicked: Function0<*>
    private var onCancelClicked: Function0<*>
    private var btnYes: Button? = null
    private var btnNo: Button? = null
    private var keyStore: KeyStore? = null
    private var cipher: Cipher? = null
    private val KEY_NAME: String
    private val context: Context
    fun setCallback(
        onYesClicked: Function0<*>,
        onNoClicked: Function0<*>,
        onCancelClicked: Function0<*>
    ): FingerPrintDialog {
        Intrinsics.checkNotNullParameter(onYesClicked, "onYesClicked")
        Intrinsics.checkNotNullParameter(onNoClicked, "onNoClicked")
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked")
        this.onYesClicked = onYesClicked
        this.onNoClicked = onNoClicked
        this.onCancelClicked = onCancelClicked
        return this
    }

    fun build(): AlertDialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Fingerprint" as CharSequence)
        builder.setMessage("Confirm fingerprint to continue" as CharSequence)
        val layoutInflater = LayoutInflater.from(context).inflate(1300108, null as ViewGroup?)
        builder.setView(layoutInflater)
        builder.setPositiveButton("Yes" as CharSequence,
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                onYesClicked.invoke()
            })
        builder.setNegativeButton(
            "No" as CharSequence,
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                onNoClicked.invoke()
            } as DialogInterface.OnClickListener)
        builder.setNeutralButton(
            "Cancel" as CharSequence,
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                onCancelClicked
            } as DialogInterface.OnClickListener)
        val ivFingerPrintIcon = layoutInflater.findViewById<View>(1000505) as ImageView
        val tvFingerPrintMessage = layoutInflater.findViewById<View>(1000433) as TextView
        val dialog = builder.create()
        dialog.setOnShowListener(OnShowListener {
            var var10000 = this@FingerPrintDialog
            var var10001 = dialog.getButton(-1)
            Intrinsics.checkNotNullExpressionValue(
                var10001,
                "dialog.getButton(AlertDialog.BUTTON_POSITIVE)"
            )
            var10000.btnYes = var10001
            var10000 = this@FingerPrintDialog
            var10001 = dialog.getButton(-2)
            Intrinsics.checkNotNullExpressionValue(
                var10001,
                "dialog.getButton(AlertDialog.BUTTON_NEGATIVE)"
            )
            var10000.btnNo = var10001
            `access$getBtnNo$p`(this@FingerPrintDialog)!!.isEnabled =
                false
            `access$getBtnYes$p`(this@FingerPrintDialog)!!.isEnabled =
                false
        } as OnShowListener)
        if (Build.VERSION.SDK_INT >= 23) {
            var var10000: Any? = context.getSystemService("fingerprint")
                ?: throw NullPointerException("null cannot be cast to non-null type android.hardware.fingerprint.FingerprintManager")
            val fingerPrintManager = var10000 as FingerprintManager
            var10000 = context.getSystemService("keyguard")
            if (var10000 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager")
            }
            val keyguardManager = var10000 as KeyguardManager
            if (!fingerPrintManager.isHardwareDetected) {
                dialog.dismiss()
                Toast.makeText(context, "Hardware not detected" as CharSequence, 0).show()
            } else if (ContextCompat.checkSelfPermission(
                    context,
                    "android.permission.USE_FINGERPRINT"
                ) != 0
            ) {
                Intrinsics.checkNotNullExpressionValue(tvFingerPrintMessage, "tvFingerPrintMessage")
                tvFingerPrintMessage.text = "Permission is not granted" as CharSequence
            } else if (!keyguardManager.isKeyguardSecure) {
                Intrinsics.checkNotNullExpressionValue(tvFingerPrintMessage, "tvFingerPrintMessage")
                tvFingerPrintMessage.text = "Please add your phone Key guard" as CharSequence
            } else if (!fingerPrintManager.hasEnrolledFingerprints()) {
                Intrinsics.checkNotNullExpressionValue(tvFingerPrintMessage, "tvFingerPrintMessage")
                tvFingerPrintMessage.text =
                    "You should add atleast 1 fingerprint to use this feature" as CharSequence
            } else {
                val fingerprintHandler = FingerPrintHandler(context)
                fingerprintHandler.auth(
                    fingerPrintManager,
                    null as FingerprintManager.CryptoObject?,
                    object : Function2<Any?, Any?, Any?> {
                        // $FF: synthetic method
                        // $FF: bridge method
                        override operator fun invoke(var1: Any, var2: Any): Any {
                            this.invoke(var1 as String, var2 as Boolean)
                            return Unit
                        }

                        operator fun invoke(message: String, isSuccess: Boolean) {
                            Intrinsics.checkNotNullParameter(message, "message")
                            Intrinsics.checkNotNullExpressionValue(
                                tvFingerPrintMessage,
                                "tvFingerPrintMessage"
                            )
                            tvFingerPrintMessage.text = message as CharSequence
                            if (isSuccess) {
                                ivFingerPrintIcon.setImageResource(700152)
                                tvFingerPrintMessage.setTextColor(
                                    ContextCompat.getColor(
                                        context,
                                        500105
                                    )
                                )
                                `access$getBtnNo$p`(this@FingerPrintDialog)!!.isEnabled =
                                    true
                                `access$getBtnYes$p`(this@FingerPrintDialog)!!.isEnabled =
                                    true
                            } else {
                                ivFingerPrintIcon.setImageResource(700095)
                                tvFingerPrintMessage.setTextColor(
                                    ContextCompat.getColor(
                                        context,
                                        500192
                                    )
                                )
                            }
                        }
                    } as Function2<*, *, *>)
            }
        }
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog")
        return dialog
    }

    @TargetApi(23)
    private fun generateKey() {
        try {
            val var10001 = KeyStore.getInstance("AndroidKeyStore")
            Intrinsics.checkNotNullExpressionValue(
                var10001,
                "KeyStore.getInstance(\"AndroidKeyStore\")"
            )
            keyStore = var10001
            val keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore")
            val var10000 = keyStore
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyStore")
            }
            var10000!!.load(null as KeyStore.LoadStoreParameter?)
            keyGenerator.init(
                KeyGenParameterSpec.Builder(KEY_NAME, 3).setBlockModes(*arrayOf("CBC"))
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(*arrayOf("PKCS7Padding"))
                    .build() as AlgorithmParameterSpec
            )
            keyGenerator.generateKey()
        } catch (var2: KeyStoreException) {
            var2.printStackTrace()
        } catch (var3: IOException) {
            var3.printStackTrace()
        } catch (var4: CertificateException) {
            var4.printStackTrace()
        } catch (var5: NoSuchAlgorithmException) {
            var5.printStackTrace()
        } catch (var6: InvalidAlgorithmParameterException) {
            var6.printStackTrace()
        } catch (var7: NoSuchProviderException) {
            var7.printStackTrace()
        }
    }

    @TargetApi(23)
    fun cipherInit(): Boolean {
        try {
            val var10001 = Cipher.getInstance("AES/CBC/PKCS7Padding")
            Intrinsics.checkNotNullExpressionValue(
                var10001,
                "Cipher.getInstance(KeyPr…ENCRYPTION_PADDING_PKCS7)"
            )
            cipher = var10001
        } catch (var9: NoSuchAlgorithmException) {
            throw (RuntimeException("Failed to get Cipher", var9 as Throwable) as Throwable)!!
        } catch (var10: NoSuchPaddingException) {
            throw (RuntimeException("Failed to get Cipher", var10 as Throwable) as Throwable)!!
        }
        return try {
            var var10000 = keyStore
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyStore")
            }
            var10000!!.load(null as KeyStore.LoadStoreParameter?)
            var10000 = keyStore
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyStore")
            }
            val var11 = var10000!!.getKey(KEY_NAME, null as CharArray?)
            if (var11 == null) {
                throw NullPointerException("null cannot be cast to non-null type javax.crypto.SecretKey")
            } else {
                val key = var11 as SecretKey
                val var12 = cipher
                if (var12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cipher")
                }
                var12!!.init(1, key as Key)
                true
            }
        } catch (var2: KeyPermanentlyInvalidatedException) {
            false
        } catch (var3: KeyStoreException) {
            throw (RuntimeException("Failed to init Cipher", var3 as Throwable) as Throwable)!!
        } catch (var4: CertificateException) {
            throw (RuntimeException("Failed to init Cipher", var4 as Throwable) as Throwable)!!
        } catch (var5: UnrecoverableKeyException) {
            throw (RuntimeException("Failed to init Cipher", var5 as Throwable) as Throwable)!!
        } catch (var6: IOException) {
            throw (RuntimeException("Failed to init Cipher", var6 as Throwable) as Throwable)!!
        } catch (var7: NoSuchAlgorithmException) {
            throw (RuntimeException("Failed to init Cipher", var7 as Throwable) as Throwable)!!
        } catch (var8: InvalidKeyException) {
            throw (RuntimeException("Failed to init Cipher", var8 as Throwable) as Throwable)!!
        }
    }

    companion object {
        // $FF: synthetic method
        fun `setCallback$default`(
            var0: FingerPrintDialog,
            var1: Function0<*>,
            var2: Function0<*>,
            var3: Function0<*>,
            var4: Int,
            var5: Any?
        ): FingerPrintDialog {
            var var1 = var1
            var var2 = var2
            var var3 = var3
            if (var4 and 1 != 0) {
                var1 = null.INSTANCE as Function0<*>
            }
            if (var4 and 2 != 0) {
                var2 = null.INSTANCE as Function0<*>
            }
            if (var4 and 4 != 0) {
                var3 = null.INSTANCE as Function0<*>
            }
            return var0.setCallback(var1, var2, var3)
        }

        // $FF: synthetic method
        fun `access$setOnYesClicked$p`(`$this`: FingerPrintDialog, var1: Function0<*>) {
            `$this`.onYesClicked = var1
        }

        // $FF: synthetic method
        fun `access$setOnNoClicked$p`(`$this`: FingerPrintDialog, var1: Function0<*>) {
            `$this`.onNoClicked = var1
        }

        // $FF: synthetic method
        fun `access$setOnCancelClicked$p`(`$this`: FingerPrintDialog, var1: Function0<*>) {
            `$this`.onCancelClicked = var1
        }

        // $FF: synthetic method
        fun `access$getBtnYes$p`(`$this`: FingerPrintDialog): Button? {
            val var10000 = `$this`.btnYes
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnYes")
            }
            return var10000
        }

        // $FF: synthetic method
        fun `access$getBtnNo$p`(`$this`: FingerPrintDialog): Button? {
            val var10000 = `$this`.btnNo
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnNo")
            }
            return var10000
        }
    }

    init {
        Intrinsics.checkNotNullParameter(context, "context")
        super()
        this.context = context
        onYesClicked = null.INSTANCE as Function0<*>
        onNoClicked = null.INSTANCE as Function0<*>
        onCancelClicked = null.INSTANCE as Function0<*>
        KEY_NAME = "AndroidKey"
    }
}