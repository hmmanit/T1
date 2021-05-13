package com.homanad.android.t1.ui.feature.home.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentHomePageBinding
import com.homanad.android.t1.ui.feature.home.page.adapter.HomeTaskAdapter
import com.homanad.android.t1.ui.feature.home.page.type.Page
import com.homanad.android.t1.ui.feature.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment(private val pageId: Int) : BaseFragment() {

    private lateinit var binding: FragmentHomePageBinding

    private val homeViewModel: HomeViewModel by viewModels()

    private val homeTaskAdapter by lazy {
        HomeTaskAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        return binding.root
    }

    override fun observeData() {

    }

    override fun setupViewModel() {
        homeViewModel.getAllBoardAndTasks()
    }

    override fun updateUI() {
        setupViews()
    }

    private fun setupViews() {
        when (pageId) {
            Page.TASKS.id -> {
                binding.recyclerSliding.run {
                    adapter = homeTaskAdapter
                    layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                }
            }
            Page.BOARDS.id -> {

            }
            Page.OTHERS.id -> {

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(pageId: Int) = HomePageFragment(pageId)
    }
}