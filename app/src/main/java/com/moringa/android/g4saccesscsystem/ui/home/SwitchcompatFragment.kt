package com.moringa.android.g4saccesscsystem.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlin.jvm.internal.DefaultConstructorMarker
import kotlin.jvm.internal.Intrinsics

@Metadata(
    mv = [1, 4, 3],
    bv = [1, 0, 3],
    k = 1,
    d1 = ["\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"],
    d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/home/SwitchcompatFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "G4S_Access_C_System.app"]
)
class SwitchcompatFragment : Fragment() {
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
        return inflater.inflate(1300116, container, false)
    }

    @Metadata(
        mv = [1, 4, 3],
        bv = [1, 0, 3],
        k = 1,
        d1 = ["\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"],
        d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/home/SwitchcompatFragment\$Companion;", "", "()V", "newInstance", "Lcom/moringa/android/g4saccesscsystem/ui/home/SwitchcompatFragment;", "param1", "", "param2", "G4S_Access_C_System.app"]
    )
    class Companion private constructor() {
        fun newInstance(param1: String, param2: String): SwitchcompatFragment {
            Intrinsics.checkNotNullParameter(param1, "param1")
            Intrinsics.checkNotNullParameter(param2, "param2")
            val var3 = SwitchcompatFragment()
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
}