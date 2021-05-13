package com.homanad.android.t1.ui.feature.home.vm

import androidx.lifecycle.ViewModel
import com.homanad.android.domain.usecase.boardAndTasks.GetAllBoardAndTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBoardAndTasksUseCase: GetAllBoardAndTasksUseCase
) : ViewModel() {
}