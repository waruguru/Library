package com.moringa.android.g4saccesscsystem.ui.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.moringa.android.g4saccesscsystem.adapter.OnBoardingAdapter
import com.moringa.android.g4saccesscsystem.databinding.FragmentOnboarding1Binding
import com.moringa.android.g4saccesscsystem.utils.PrefUtils
import kotlin.jvm.internal.Intrinsics
//
//@Metadata(
//    mv = [1, 4, 3],
//    bv = [1, 0, 3],
//    k = 1,
//    d1 = ["\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"],
//    d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/auth/onboarding/Onboarding1Fragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/moringa/android/g4saccesscsystem/databinding/FragmentOnboarding1Binding;", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "pagerPosition", "", "handleBackButton", "", "loadSliders", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Companion", "G4S_Access_C_System.app"]
//)
class Onboarding1Fragment : Fragment() {
    private var binding: FragmentOnboarding1Binding? = null
    private val pagerPosition = 0
    var button: Button? = null
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Intrinsics.checkNotNullParameter(inflater, "inflater")
        val var10001 = FragmentOnboarding1Binding.inflate(this.layoutInflater)
        Intrinsics.checkNotNullExpressionValue(
            var10001,
            "FragmentOnboarding1Binding.inflate(layoutInflater)"
        )
        binding = var10001
        loadSliders()
        handleBackButton()
        val var10000 = binding
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        return var10000!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Intrinsics.checkNotNullParameter(view, "view")
        super.onViewCreated(view, savedInstanceState)
        val var10000 = binding
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        var10000!!.btnSetupAccount.setOnClickListener(View.OnClickListener {
            val var10000 = PrefUtils
            val var10001 = requireContext()
            Intrinsics.checkNotNullExpressionValue(var10001, "requireContext()")
            var10000.setPreference(var10001, "isExisting", "false")
            this@Onboarding1Fragment.findNavController().navigate(1000107)
        })
    }

    private fun handleBackButton() {}
    private fun loadSliders() {
        val var10002 = requireContext()
        Intrinsics.checkNotNullExpressionValue(var10002, "requireContext()")
        val onBoardingAdapter = OnBoardingAdapter(var10002)
        var var10000 = binding
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        val var2 = var10000!!.pager
        Intrinsics.checkNotNullExpressionValue(var2, "binding.pager")
        var2.adapter = onBoardingAdapter
        var10000 = binding
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        val var3 = var10000!!.tabDots
        val var10001 = binding
        if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        var3.setupWithViewPager(var10001!!.pager, true)
        onBoardingAdapter.notifyDataSetChanged()
        var10000 = binding
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding")
        }
        var10000!!.pager.addOnPageChangeListener((object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {}
        } as OnPageChangeListener))
    }

//    @Metadata(
//        mv = [1, 4, 3],
//        bv = [1, 0, 3],
//        k = 1,
//        d1 = ["\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"],
//        d2 = ["Lcom/moringa/android/g4saccesscsystem/ui/auth/onboarding/Onboarding1Fragment\$Companion;", "", "()V", "newInstance", "Lcom/moringa/android/g4saccesscsystem/ui/auth/onboarding/Onboarding1Fragment;", "param1", "", "param2", "G4S_Access_C_System.app"]
//    )
    class Companion private constructor() {
        fun newInstance(param1: String, param2: String): Onboarding1Fragment {
            Intrinsics.checkNotNullParameter(param1, "param1")
            Intrinsics.checkNotNullParameter(param2, "param2")
            val var3 = Onboarding1Fragment()
            val var4 = false
            val var5 = false
            val var7 = false
            return var3
        }

        // $FF: synthetic method
        constructor(`$constructor_marker`: DefaultConstructorMarker?) : this() {}
    }

    companion object {
        val Companion = Companion(null as DefaultConstructorMarker?)
    }
}