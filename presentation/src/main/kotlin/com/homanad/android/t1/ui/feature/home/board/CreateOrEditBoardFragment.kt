package com.homanad.android.t1.ui.feature.home.board

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.transition.Slide
import com.google.android.material.transition.MaterialContainerTransform
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.context.themeColor
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentCreateOrEditBoardBinding

class CreateOrEditBoardFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateOrEditBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_create_or_edit_board,
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

    companion object {
        @JvmStatic
        fun newInstance() = CreateOrEditBoardFragment()
    }
}