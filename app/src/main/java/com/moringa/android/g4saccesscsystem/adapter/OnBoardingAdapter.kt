package com.moringa.android.g4saccesscsystem.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import kotlin.jvm.internal.Intrinsics

//@Metadata(
//    mv = [1, 4, 3],
//    bv = [1, 0, 3],
//    k = 1,
//    d1 = ["\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u001f\u001a\u00020\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006 "],
//    d2 = ["Lcom/moringa/android/g4saccesscsystem/adapter/OnBoardingAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "layoutInflater", "Landroid/view/LayoutInflater;", "splaschreenimages", "", "splashscreenDescriptions", "", "", "[Ljava/lang/String;", "splashscreenTitle", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "notifyDatasetChanged", "G4S_Access_C_System.app"]
//)
@SuppressLint("WrongConstant")
class OnBoardingAdapter(context: Context) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private val splashscreenTitle: Array<String?>
    private val splashscreenDescriptions: Array<String?>
    private val splaschreenimages: IntArray
    private var context: Context
    fun notifyDatasetChanged() {
        val var1 = "Not yet implemented"
        val var2 = false
        throw (NotImplementedError("An operation is not implemented: $var1") as Throwable)
    }

    override fun getCount(): Int {
        return splashscreenTitle.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        Intrinsics.checkNotNullParameter(view, "view")
        Intrinsics.checkNotNullParameter(`object`, "object")
        return view === `object`
    }

    @SuppressLint("ResourceType")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Intrinsics.checkNotNullParameter(container, "container")
        var var10000 = layoutInflater!!.inflate(1300080, container, false)
        Intrinsics.checkNotNullExpressionValue(
            var10000,
            "layoutInflater.inflate(R…slider, container, false)"
        )
        val view = var10000
        splashscreenTitle[0] = context.getString(1900117)
        splashscreenTitle[1] = context.getString(1900147)
        splashscreenTitle[2] = context.getString(1900045)
        splashscreenDescriptions[0] = context.getString(1900117)
        splashscreenDescriptions[1] = context.getString(1900147)
        splashscreenDescriptions[2] = context.getString(1900045)
        var tvSplashScreenTitle: TextView? = null
        val tvSplashScreenDescri: TextView? = null
        var imgSplashScreen: ImageView? = null
        var10000 = view.findViewById(1000440)
        Intrinsics.checkNotNullExpressionValue(var10000, "view.findViewById(R.id.tv_slider_title)")
        tvSplashScreenTitle = var10000 as TextView
        var10000 = view.findViewById(1000252)
        Intrinsics.checkNotNullExpressionValue(var10000, "view.findViewById(R.id.iv_slider)")
        imgSplashScreen = var10000 as ImageView
        tvSplashScreenTitle.text = splashscreenTitle[position]
        imgSplashScreen!!.setImageResource(splaschreenimages[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Intrinsics.checkNotNullParameter(container, "container")
        Intrinsics.checkNotNullParameter(`object`, "object")
    }

    fun getContext(): Context {
        return context
    }

    fun setContext(var1: Context) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>")
        context = var1
    }

    init {
        Intrinsics.checkNotNullParameter(context, "context")
        super()
        this.context = context
        splashscreenTitle = arrayOfNulls(3)
        splashscreenDescriptions = arrayOfNulls(3)
        splaschreenimages = intArrayOf(700070, 700175, 700174)
        val var10001 = this.context
        Intrinsics.checkNotNull(var10001)
        val var2 = var10001.getSystemService("layout_inflater")
        if (var2 == null) {
            throw NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater")
        } else {
            layoutInflater = var2 as LayoutInflater
        }
    }
}