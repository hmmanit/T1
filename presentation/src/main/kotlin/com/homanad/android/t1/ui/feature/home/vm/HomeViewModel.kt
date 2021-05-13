package com.homanad.android.t1.ui.feature.home.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homanad.android.domain.usecase.boardAndTasks.GetAllBoardAndTasksUseCase
import com.homanad.android.domain.usecase.taskInBoard.GetAllTaskInBoardUseCase
import com.homanad.android.t1.ui.feature.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBoardAndTasksUseCase: GetAllBoardAndTasksUseCase,
    private val getAllTaskInBoardUseCase: GetAllTaskInBoardUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Idle)
    val state: StateFlow<HomeState> = _state

    fun getAllBoardAndTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllBoardAndTasksUseCase().forEach {
                Log.d("aaaaaaaaaaaaa", it.toString())
            }
        }
    }

    fun getAllTaskInBoard() {
        viewModelScope.launch {
//            getAllTaskInBoardUseCase().forEach {
////                Log.d("aaaaaaaaaaaaa2", it.toString())
//            }
            _state.value = try {
                HomeState.TaskInBoardsReturned(getAllTaskInBoardUseCase())
            } catch (e: Exception) {
                HomeState.Error("Can't get Task in Boards")
            }
        }
    }
}