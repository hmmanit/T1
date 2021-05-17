package com.homanad.android.t1.ui.feature.home.task

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Slide
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.google.android.material.transition.MaterialContainerTransform
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.context.themeColor
import com.homanad.android.t1.R
import com.homanad.android.t1.common.BASE_SPACE_ITEM_DECORATION
import com.homanad.android.t1.databinding.FragmentCreateOrEditTaskBinding
import com.homanad.android.t1.ui.feature.home.page.adapter.HomeBoardAdapter
import com.homanad.android.t1.ui.feature.home.state.HomeState
import com.homanad.android.t1.ui.feature.home.task.adapter.PriorityAdapter
import com.homanad.android.t1.ui.feature.home.task.adapter.StatusAdapter
import com.homanad.android.t1.ui.feature.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class CreateOrEditTaskFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateOrEditTaskBinding
    private val homeViewModel: HomeViewModel by viewModels()

    private val homeBoardAdapter by lazy {
        HomeBoardAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_create_or_edit_task,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = MaterialContainerTransform().apply {
            // Manually add the Views to be shared since this is not a standard Fragment to
            // Fragment shared element transition.
            startView = requireActivity().findViewById(R.id.fab_create)
            endView = binding.container
            duration = resources.getInteger(R.integer.motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            containerColor = requireContext().themeColor(R.attr.colorSurface)
            startContainerColor = requireContext().themeColor(R.attr.colorSecondary)
            endContainerColor = requireContext().themeColor(R.attr.colorSurface)
        }
        returnTransition = Slide(Gravity.END).apply {
            duration = resources.getInteger(R.integer.motion_duration_large).toLong()
            addTarget(R.id.container)
        }
    }

    override fun observeData() {
        lifecycleScope.launch {
            homeViewModel.state.collect {
                when (it) {
                    is HomeState.BoardAndTasksReturned -> {
                        homeBoardAdapter.setBoards(it.boardAndTasks)
                    }
                    else -> {
                    }
                }
            }
        }
    }

    override fun setupViewModel() {
        homeViewModel.getAllBoardAndTasks()
    }

    private val datePicker by lazy {
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
    }

    private fun getTimePicker(): MaterialTimePicker {
        return MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(12)
            .setTitleText("Select time")
            .build()
    }

    override fun updateUI() {
        val priorityAdapter = PriorityAdapter()
        val statusAdapter = StatusAdapter(requireContext())
        with(binding) {
            textStartDate.setOnClickListener {
                datePicker.addOnPositiveButtonClickListener {
                    textStartDate.setText(getDateString(it))
                }
                datePicker.show(childFragmentManager, TAG_DATE_PICKER)
            }

            textEndDate.setOnClickListener {
                datePicker.addOnPositiveButtonClickListener {
                    textEndDate.setText(getDateString(it))
                }
                datePicker.show(childFragmentManager, TAG_DATE_PICKER)
            }

            textStartTime.setOnClickListener {
                val picker = getTimePicker()
                picker.addOnPositiveButtonClickListener {
                    textStartTime.setText("${picker.hour}:${picker.minute}")
                }
                picker.show(childFragmentManager, TAG_TIME_PICKER)
            }

            textEndTime.setOnClickListener {
                val picker = getTimePicker()
                picker.addOnPositiveButtonClickListener {
                    textEndTime.setText("${picker.hour}:${picker.minute}")
                }
                picker.show(childFragmentManager, TAG_TIME_PICKER)
            }

            recyclerPriority.run {
                adapter = priorityAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                addItemDecoration(SpaceItemDecoration(BASE_SPACE_ITEM_DECORATION))
            }

            spinnerStatus.run {
                adapter = statusAdapter
            }

            recyclerBoard.run {
                adapter = homeBoardAdapter
                addItemDecoration(SpaceItemDecoration(BASE_SPACE_ITEM_DECORATION))
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateOrEditTaskFragment()

        private const val TAG_DATE_PICKER = "TAG_DATE_PICKER"
        private const val TAG_TIME_PICKER = "TAG_TIME_PICKER"
    }

    fun getDateString(timestamp: Long): String {
        val calendar: Calendar = GregorianCalendar()
        calendar.timeInMillis = timestamp
        var datetime = ""
        if (calendar.get(Calendar.DATE) < 10) datetime += '0'
        datetime += calendar.get(Calendar.DATE)
        datetime += "/"
        if (calendar.get(Calendar.MONTH) < 9) datetime += '0'
        datetime += calendar.get(Calendar.MONTH) + 1
        datetime += "/"
        datetime += calendar.get(Calendar.YEAR)
//        datetime += " "
//        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) datetime += '0'
//        datetime += calendar.get(Calendar.HOUR_OF_DAY)
//        datetime += ":"
//        if (calendar.get(Calendar.MINUTE) < 10) datetime += '0'
//        datetime += calendar.get(Calendar.MINUTE)
        return datetime
    }

    fun getTimeString(timestamp: Long): String {
        val calendar: Calendar = GregorianCalendar()
        calendar.timeInMillis = timestamp
        var datetime = ""
//        if (calendar.get(Calendar.DATE) < 10) datetime += '0'
//        datetime += calendar.get(Calendar.DATE)
//        datetime += "/"
//        if (calendar.get(Calendar.MONTH) < 9) datetime += '0'
//        datetime += calendar.get(Calendar.MONTH) + 1
//        datetime += "/"
//        datetime += calendar.get(Calendar.YEAR)
//        datetime += " "
        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) datetime += '0'
        datetime += calendar.get(Calendar.HOUR_OF_DAY)
        datetime += ":"
        if (calendar.get(Calendar.MINUTE) < 10) datetime += '0'
        datetime += calendar.get(Calendar.MINUTE)
        return datetime
    }
}