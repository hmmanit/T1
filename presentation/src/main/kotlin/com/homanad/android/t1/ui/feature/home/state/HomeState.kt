package com.homanad.android.t1.ui.feature.home.state

import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.domain.entity.datamodel.TaskInBoard

sealed class HomeState {
    object Idle : HomeState()
    object Loading : HomeState()
    data class Error(val message: String) : HomeState()

    data class TaskCreated(val taskId: Long) : HomeState()
    data class BoardCreated(val boardId: Long) : HomeState()
    data class TaskInBoardsReturned(val taskInBoards: List<TaskInBoard>) : HomeState()
    data class BoardAndTasksReturned(val boardAndTasks: List<BoardAndTasks>) : HomeState()
    data class TasksInDateReturned(val tasksInDate: List<TaskInBoard>) : HomeState()
}