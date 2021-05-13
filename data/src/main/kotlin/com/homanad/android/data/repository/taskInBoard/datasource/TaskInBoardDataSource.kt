package com.homanad.android.data.repository.taskInBoard.datasource

import com.homanad.android.domain.entity.datamodel.TaskInBoard

interface TaskInBoardDataSource {
    suspend fun getAllTaskInBoardUseCase(): List<TaskInBoard>
}