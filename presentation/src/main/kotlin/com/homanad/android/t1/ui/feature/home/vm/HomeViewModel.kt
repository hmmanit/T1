package com.homanad.android.t1.ui.feature.home.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homanad.android.domain.usecase.boardAndTasks.GetAllBoardAndTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBoardAndTasksUseCase: GetAllBoardAndTasksUseCase
) : ViewModel() {

    fun getAllBoardAndTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllBoardAndTasksUseCase().forEach {
                Log.d("aaaaaaaaaaaaa", it.toString())
            }
        }
    }
}