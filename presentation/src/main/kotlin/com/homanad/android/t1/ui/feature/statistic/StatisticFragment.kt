package com.homanad.android.t1.ui.feature.statistic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.datepicker.MaterialDatePicker
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import com.homanad.android.domain.common.getDateMonthYear
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentStatisticBinding
import dagger.hilt.android.AndroidEntryPoint

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
                            setOnClickListener {
                                val picker = getDatePicker()
                                picker.addOnPositiveButtonClickListener {
                                    selectTime.text = it.getDateMonthYear()
                                }
                                picker.show(childFragmentManager, "")
                            }
                        }
                    }
                    R.id.select_month -> {
                        selectTime.visible()
                    }
                    R.id.select_period -> {
                        selectTime.visible()
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

    companion object {
        @JvmStatic
        fun newInstance() = StatisticFragment()
    }
}