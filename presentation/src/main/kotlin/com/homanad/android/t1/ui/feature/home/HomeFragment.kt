package com.homanad.android.t1.ui.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import com.homanad.android.common.utilities.drawReenterTransition
import com.homanad.android.common.utilities.getExitMaterialElevationScale
import com.homanad.android.common.utilities.getReturnMaterialSharedAxis
import com.homanad.android.t1.R
import com.homanad.android.t1.common.BASE_SPACE_ITEM_DECORATION
import com.homanad.android.t1.databinding.FragmentHomeBinding
import com.homanad.android.t1.ui.feature.home.page.adapter.HomeViewPagerAdapter
import com.homanad.android.t1.ui.feature.home.page.type.Page
import com.homanad.android.t1.ui.feature.home.state.HomeState
import com.homanad.android.t1.ui.feature.home.task.adapter.TaskAdapter
import com.homanad.android.t1.ui.feature.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    private val taskAdapter by lazy {
        TaskAdapter()
    }

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
        lifecycleScope.launch {
            homeViewModel.state.collect {
                when (it) {
                    is HomeState.TaskInBoardsReturned -> {
                        taskAdapter.setTasks(it.taskInBoards)
                    }
                    else -> {
                    }
                }
            }
        }
    }

    override fun setupViewModel() {
        homeViewModel.getAllTaskInBoard()
    }

    override fun updateUI() {
        setupTabs()
        with(binding) {
            recyclerToday.run {
                adapter = taskAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(SpaceItemDecoration(BASE_SPACE_ITEM_DECORATION))
            }
        }
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