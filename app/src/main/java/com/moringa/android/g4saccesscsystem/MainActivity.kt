package com.moringa.android.g4saccesscsystem

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moringa.android.g4saccesscsystem.databinding.ActivityMainBinding
import kotlin.jvm.internal.Intrinsics

@Metadata(
    mv = [1, 4, 3],
    bv = [1, 0, 3],
    k = 1,
    d1 = ["\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"],
    d2 = ["Lcom/moringa/android/g4saccesscsystem/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/moringa/android/g4saccesscsystem/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "G4S_Access_C_System.app"]
)
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var var10001: ActivityMainBinding? = ActivityMainBinding.inflate(this.layoutInflater)
        Intrinsics.checkNotNullExpressionValue(
            var10001,
            "ActivityMainBinding.inflate(layoutInflater)"
        )
        binding = var10001
        var10001 = binding
        if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        this.setContentView(var10001!!.root as View)
        val navController = this.findNavController(1000522)
        val var10000 = binding
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        val var3 = var10000!!.bottomNav
        Intrinsics.checkNotNullExpressionValue(var3, "binding.bottomNav")
        var3.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(OnDestinationChangedListener { `$noName_0`, destination, `$noName_2` ->
            Intrinsics.checkNotNullParameter(`$noName_0`, "<anonymous parameter 0>")
            Intrinsics.checkNotNullParameter(destination, "destination")
            val var10000: BottomNavigationView
            if (destination.id == 1000160) {
                var10000 = `access$getBinding$p`(this@MainActivity)!!.bottomNav
                Intrinsics.checkNotNullExpressionValue(var10000, "binding.bottomNav")
                var10000.visibility = 0
            } else {
                var10000 = `access$getBinding$p`(this@MainActivity)!!.bottomNav
                Intrinsics.checkNotNullExpressionValue(var10000, "binding.bottomNav")
                var10000.visibility = 8
            }
        })
    }

    companion object {
        // $FF: synthetic method
        fun `access$getBinding$p`(`$this`: MainActivity): ActivityMainBinding? {
            val var10000 = `$this`.binding
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding")
            }
            return var10000
        }

        // $FF: synthetic method
        fun `access$setBinding$p`(`$this`: MainActivity, var1: ActivityMainBinding?) {
            `$this`.binding = var1
        }
    }
}