package com.moringa.android.g4saccesscsystem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.moringa.android.g4saccesscsystem.R

class OnBoardingAdapter(var context: Context):PagerAdapter(){
    private val layoutInflater: LayoutInflater

    private val splashscreenTitle = arrayOfNulls<String>(3)
    private val splashscreenDescriptions = arrayOfNulls<String>(3)
    private val splaschreenimages = intArrayOf(
        R.drawable.group_67, R.drawable.image_2,
        R.drawable.image_3
    )

    init {
        layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    fun notifyDatasetChanged() {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        return splashscreenTitle.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.introslider, container, false)
        splashscreenTitle[0] = context.getString(R.string.Checkin_Checkout)
        splashscreenTitle[1] = context.getString(R.string.Laptop_Scan)
        splashscreenTitle[2] = context.getString(R.string.Centralized_Data)

        splashscreenDescriptions[0] = context.getString(R.string.Checkin_Checkout)
        splashscreenDescriptions[1] = context.getString(R.string.Laptop_Scan)
        splashscreenDescriptions[2] = context.getString(R.string.Centralized_Data)

        val tvSplashScreenTitle: TextView
        val tvSplashScreenDescri: TextView
        val imgSplashScreen: ImageView

        tvSplashScreenTitle = view.findViewById(R.id.tv_slider_title)
        imgSplashScreen = view.findViewById(R.id.iv_slider)
//        tvSplashScreenDescri=view.findViewById(R.id.tv_slider_descr)

        tvSplashScreenTitle.text = splashscreenTitle[position]
        //   tvSplashScreenDescri.text=splashscreenDescriptions[position]

        imgSplashScreen.setImageResource(splaschreenimages[position])

        container.addView(view)

        return view

    }
    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
       // container.removeView(`object` as RelativeLayout)
    }


}