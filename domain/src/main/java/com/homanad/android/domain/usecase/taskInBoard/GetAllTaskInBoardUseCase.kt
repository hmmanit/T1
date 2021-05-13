package com.homanad.android.domain.usecase.taskInBoard

import com.homanad.android.domain.common.UseCase
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import com.homanad.android.domain.repository.TaskInBoardRepository

class GetAllTaskInBoardUseCase(
    private val taskInBoardRepository: TaskInBoardRepository
) : UseCase<List<TaskInBoard>>() {

    override suspend fun create(): List<TaskInBoard> {
        return taskInBoardRepository.getAllTaskInBoardUseCase()
    }
}