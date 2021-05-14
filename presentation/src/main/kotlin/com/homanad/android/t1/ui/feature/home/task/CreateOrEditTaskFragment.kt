package com.homanad.android.t1.ui.feature.home.task

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Slide
import com.google.android.material.transition.MaterialContainerTransform
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.context.themeColor
import com.homanad.android.t1.R
import com.homanad.android.t1.common.BASE_SPACE_ITEM_DECORATION
import com.homanad.android.t1.databinding.FragmentCreateOrEditTaskBinding
import com.homanad.android.t1.ui.feature.home.task.adapter.PriorityAdapter

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

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        val priorityAdapter = PriorityAdapter()
        with(binding) {
            recyclerPriority.run {
                adapter = priorityAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                addItemDecoration(SpaceItemDecoration(BASE_SPACE_ITEM_DECORATION))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateOrEditTaskFragment()
    }
}