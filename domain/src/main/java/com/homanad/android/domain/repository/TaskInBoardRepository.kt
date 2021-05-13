package com.homanad.android.domain.repository

import com.homanad.android.domain.entity.datamodel.TaskInBoard

interface TaskInBoardRepository {
    suspend fun getAllTaskInBoardUseCase(): List<TaskInBoard>
}