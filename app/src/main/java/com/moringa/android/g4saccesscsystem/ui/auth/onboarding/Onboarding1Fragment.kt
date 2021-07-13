package com.moringa.android.g4saccesscsystem.ui.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.moringa.android.g4saccesscsystem.R
import com.moringa.android.g4saccesscsystem.utils.PrefUtils
import com.moringa.android.g4saccesscsystem.adapter.OnBoardingAdapter
import com.moringa.android.g4saccesscsystem.databinding.FragmentOnboarding1Binding


class Onboarding1Fragment : Fragment() {
    private lateinit var binding: FragmentOnboarding1Binding

    /*private var _binding: FragmentOnboarding1Binding? = null
    private val binding get() = _binding!!*/

    private var pagerPosition = 0
    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding1Binding.inflate(layoutInflater)
        /*val view = binding.root*/


        loadSliders()
        handleBackButton()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSetupAccount.setOnClickListener {
            PrefUtils.setPreference(requireContext(), "isExisting","false")
            findNavController().navigate(R.id.action_onboarding1Fragment_to_loginFragment)
        }

    }

    private fun handleBackButton() {
    }

    private fun loadSliders() {
        val onBoardingAdapter = OnBoardingAdapter(requireContext())
        binding.pager.adapter =onBoardingAdapter
        binding.tabDots.setupWithViewPager(binding.pager, true)
        onBoardingAdapter.notifyDataSetChanged()

        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int ) {

            }
            override fun onPageScrolled(
                position: Int ,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
//             binding.adsViewPager.currentItem=
               /* if (position==0){
                    binding.tvSliderDescr.setText(R.string.you_can_now_start)
                }else if (position==1){
                    binding.tvSliderDescr.setText(R.string.you_can_now_send)
                }else{
                    binding.tvSliderDescr.setText(R.string.you_can_now_get_instant)

                }*/
            }

            override fun onPageSelected(position: Int) {



            }
        })
    }


    companion object {

        fun newInstance(param1: String, param2: String) =
            Onboarding1Fragment().apply {

            }
    }



}