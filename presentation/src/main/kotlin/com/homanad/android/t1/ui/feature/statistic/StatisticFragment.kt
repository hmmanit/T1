package com.homanad.android.t1.ui.feature.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.datepicker.MaterialDatePicker
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import com.homanad.android.domain.common.dd_space_MMM_space_yyyy
import com.homanad.android.domain.common.getDateMonthYear
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentStatisticBinding
import com.homanad.android.t1.ui.common.MonthYearPickerDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class StatisticFragment : BaseFragment() {

    private lateinit var binding: FragmentStatisticBinding

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
                            selectTime.text = System.currentTimeMillis().getDateMonthYear(dd_space_MMM_space_yyyy)
                            setOnClickListener {
                                val picker = getDatePicker()
                                picker.addOnPositiveButtonClickListener {
                                    selectTime.text = it.getDateMonthYear(dd_space_MMM_space_yyyy)
                                }
                                picker.show(parentFragmentManager, "MaterialDatePicker")
                            }
                        }
                    }
                    R.id.select_month -> {
                        selectTime.run {
                            visible()
                            setOnClickListener {
                                val picker = getMonthYearPicker { view, year, month, dayOfMonth ->

                                }
                                picker.show(parentFragmentManager, "MonthYearPickerDialog")
                            }
                        }
                    }
                    R.id.select_period -> {
                        selectTime.run {
                            visible()
                            selectTime.text = MaterialDatePicker.thisMonthInUtcMilliseconds()
                                .getDateMonthYear(dd_space_MMM_space_yyyy) + " - " +
                                    MaterialDatePicker.todayInUtcMilliseconds()
                                        .getDateMonthYear(dd_space_MMM_space_yyyy)
                            setOnClickListener {
                                val picker = getDateRangePicker()
                                picker.addOnPositiveButtonClickListener {
                                    selectTime.text =
                                        it.first?.getDateMonthYear(dd_space_MMM_space_yyyy) + " - " + it.second?.getDateMonthYear(
                                            dd_space_MMM_space_yyyy
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
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
    }

    private fun getMonthYearPicker(
        listener: (view: View?, year: Int, month: Int, dayOfMonth: Int) -> Unit
    ): MonthYearPickerDialog {
        return MonthYearPickerDialog(Date(System.currentTimeMillis())).apply {
            setListener(listener)
        }
    }

    private fun getDateRangePicker(): MaterialDatePicker<androidx.core.util.Pair<Long, Long>> {
        return MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText("Select date")
            .setSelection(
                androidx.core.util.Pair(
                    MaterialDatePicker.thisMonthInUtcMilliseconds(),
                    MaterialDatePicker.todayInUtcMilliseconds()
                )
            )
            .build()
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatisticFragment()
    }
}