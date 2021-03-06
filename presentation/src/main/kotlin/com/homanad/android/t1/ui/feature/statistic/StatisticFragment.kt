package com.homanad.android.t1.ui.feature.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.resource.asString
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import com.homanad.android.domain.common.MMM_space_yyyy
import com.homanad.android.domain.common.dd_space_MMM_space_yyyy
import com.homanad.android.domain.common.getDateTime
import com.homanad.android.domain.common.getTimeInMillis
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentStatisticBinding
import com.homanad.android.t1.ui.common.MonthYearPickerDialog
import com.homanad.android.t1.ui.feature.statistic.vm.StatisticViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class StatisticFragment : BaseFragment() {

    private lateinit var binding: FragmentStatisticBinding

    private val statisticViewModel: StatisticViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_statistic, container, false)
        return binding.root
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        with(binding) {
            toggleType.addOnButtonCheckedListener { group, checkedId, isChecked ->
                when (checkedId) {
                    R.id.select_board -> {
                        selectTime.gone()
                    }
                    R.id.select_date -> {
                        selectTime.run {
                            visible()
                            selectTime.text = statisticViewModel.dateInMillis.getDateTime(dd_space_MMM_space_yyyy)
                            setOnClickListener {
                                val picker = getDatePicker()
                                picker.addOnPositiveButtonClickListener {
                                    statisticViewModel.dateInMillis = it
                                    selectTime.text = it.getDateTime(dd_space_MMM_space_yyyy)
                                }
                                picker.show(parentFragmentManager, "MaterialDatePicker")
                            }
                        }
                    }
                    R.id.select_month -> {
                        selectTime.run {
                            visible()
                            selectTime.text = statisticViewModel.monthInMillis.getDateTime(MMM_space_yyyy)
                            setOnClickListener {
                                val picker = getMonthYearPicker { _, year, month, dayOfMonth ->
                                    val time = getTimeInMillis(year, month, dayOfMonth)
                                    statisticViewModel.monthInMillis = time
                                    selectTime.text = time.getDateTime(MMM_space_yyyy)
                                }
                                picker.show(parentFragmentManager, "MonthYearPickerDialog")
                            }
                        }
                    }
                    R.id.select_period -> {
                        selectTime.run {
                            visible()
                            val template = R.string.date_to_date.asString(requireContext())
                            selectTime.text = String.format(
                                template,
                                statisticViewModel.startDateInMillis
                                    .getDateTime(dd_space_MMM_space_yyyy),
                                statisticViewModel.endDateInMillis
                                    .getDateTime(dd_space_MMM_space_yyyy)
                            )

                            setOnClickListener {
                                val picker = getDateRangePicker()
                                picker.addOnPositiveButtonClickListener {
                                    statisticViewModel.startDateInMillis =
                                        it?.first ?: statisticViewModel.startDateInMillis
                                    statisticViewModel.endDateInMillis =
                                        it?.second ?: statisticViewModel.endDateInMillis
                                    selectTime.text = String.format(
                                        template,
                                        it.first?.getDateTime(dd_space_MMM_space_yyyy),
                                        it.second?.getDateTime(dd_space_MMM_space_yyyy)
                                    )
                                }
                                picker.show(parentFragmentManager, "MaterialDatePicker")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getDatePicker(): MaterialDatePicker<Long> {
        return MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(statisticViewModel.dateInMillis)
            .build()
    }

    private fun getMonthYearPicker(
        listener: (view: View?, year: Int, month: Int, dayOfMonth: Int) -> Unit
    ): MonthYearPickerDialog {
        return MonthYearPickerDialog(Date(statisticViewModel.monthInMillis)).apply {
            setListener(listener)
        }
    }

    private fun getDateRangePicker(): MaterialDatePicker<androidx.core.util.Pair<Long, Long>> {
        return MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText("Select date")
            .setSelection(
                androidx.core.util.Pair(statisticViewModel.startDateInMillis, statisticViewModel.endDateInMillis)
            )
            .build()
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatisticFragment()
    }
}