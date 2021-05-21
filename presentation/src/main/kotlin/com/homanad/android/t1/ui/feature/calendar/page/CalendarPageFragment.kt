package com.homanad.android.t1.ui.feature.calendar.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.t1.R
import com.homanad.android.t1.common.BASE_SPACE_ITEM_DECORATION
import com.homanad.android.t1.databinding.FragmentCalendarPageBinding
import com.homanad.android.t1.ui.feature.home.state.HomeState
import com.homanad.android.t1.ui.feature.home.task.adapter.TaskAdapter
import com.homanad.android.t1.ui.feature.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CalendarPageFragment(private val timeInMillis: Long) : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentCalendarPageBinding

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
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_calendar_page, container, false)
        return binding.root
    }

    override fun observeData() {
        lifecycleScope.launch {
            homeViewModel.state.collect {
                when (it) {
                    is HomeState.TasksInDateReturned -> {
                        taskAdapter.setTasks(it.tasksInDate)
                    }
                    else -> {

                    }
                }
            }
        }
    }

    override fun setupViewModel() {
        homeViewModel.getTasksInDate(timeInMillis)
    }

    override fun updateUI() {
        with(binding) {
            recyclerTask.run {
                adapter = taskAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(SpaceItemDecoration(BASE_SPACE_ITEM_DECORATION))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(timeInMillis: Long) = CalendarPageFragment(timeInMillis)
    }
}