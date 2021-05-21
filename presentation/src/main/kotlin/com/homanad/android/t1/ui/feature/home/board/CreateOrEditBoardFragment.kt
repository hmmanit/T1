package com.homanad.android.t1.ui.feature.home.board

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Slide
import com.google.android.material.transition.MaterialContainerTransform
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.context.themeColor
import com.homanad.android.domain.entity.Board
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentCreateOrEditBoardBinding
import com.homanad.android.t1.ui.common.ColorAdapter
import com.homanad.android.t1.ui.feature.home.state.HomeState
import com.homanad.android.t1.ui.feature.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreateOrEditBoardFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateOrEditBoardBinding

    private val homeViewModel: HomeViewModel by viewModels()

    private val colorAdapter by lazy {
        ColorAdapter(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {
        lifecycleScope.launch {
            homeViewModel.state.collect {
                when (it) {
                    is HomeState.BoardCreated -> {
                        findNavController().navigateUp()
                    }
                    else -> {

                    }
                }
            }
        }
    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        with(binding) {
            buttonCreate.setOnClickListener {
                val title = textTitle.text.toString()
                val description = textDescription.text.toString()

                val board = Board(0, title, description, colorAdapter.getSelectedColor(), "")
                homeViewModel.createBoard(board)
            }
            layoutColorSelection.recyclerViewColors.run {
                adapter = colorAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
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