package com.homanad.android.t1.ui.feature.home.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentCreateOrEditTaskBinding

class CreateOrEditTaskFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateOrEditTaskBinding

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

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateOrEditTaskFragment()
    }
}