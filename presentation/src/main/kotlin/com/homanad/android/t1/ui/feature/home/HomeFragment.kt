package com.homanad.android.t1.ui.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import com.homanad.android.common.utilities.drawReenterTransition
import com.homanad.android.common.utilities.getExitMaterialElevationScale
import com.homanad.android.common.utilities.getReturnMaterialSharedAxis
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentHomeBinding
import com.homanad.android.t1.ui.feature.home.page.adapter.HomeViewPagerAdapter
import com.homanad.android.t1.ui.feature.home.page.type.Page

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawReenterTransition(view)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        setupTabs()
    }

    private fun setupTabs() {
        binding.fabCreate.run {
            setShowMotionSpecResource(R.animator.fab_show)
            setHideMotionSpecResource(R.animator.fab_hide)
        }
        val adapter = HomeViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->
            tab.text = adapter.pages[position].title
//            tab.icon = R.drawable.ic_home.asDrawable(requireContext())
        }.attach()
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (adapter.pages[position].id) {
                    Page.TASKS.id -> {
                        binding.fabCreate.visible()
                        binding.fabCreate.setOnClickListener {
                            exitTransition = getExitMaterialElevationScale(
                                resources.getInteger(R.integer.motion_duration_large).toLong()
                            )
                            reenterTransition = getReturnMaterialSharedAxis(
                                resources.getInteger(R.integer.motion_duration_large).toLong()
                            )

                            val directions =
                                HomeFragmentDirections.actionHomeFragmentToCreateOrEditTaskFragment()
                            findNavController().navigate(directions)
                        }
                    }
                    Page.BOARDS.id -> {
                        binding.fabCreate.visible()
                        binding.fabCreate.setOnClickListener {
                            exitTransition = getExitMaterialElevationScale(
                                resources.getInteger(R.integer.motion_duration_large).toLong()
                            )
                            reenterTransition = getReturnMaterialSharedAxis(
                                resources.getInteger(R.integer.motion_duration_large).toLong()
                            )

                            val directions =
                                HomeFragmentDirections.actionHomeFragmentToCreateOrEditBoardFragment()
                            findNavController().navigate(directions)
                        }
                    }
                    Page.OTHERS.id -> {
                        binding.fabCreate.gone()
                    }
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}