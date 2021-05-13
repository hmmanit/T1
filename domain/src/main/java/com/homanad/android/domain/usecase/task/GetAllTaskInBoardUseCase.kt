package com.homanad.android.domain.usecase.task

import com.homanad.android.domain.common.UseCase
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import com.homanad.android.domain.repository.TaskRepository

class GetAllTaskInBoardUseCase(
    private val taskRepository: TaskRepository
) : UseCase<List<TaskInBoard>>() {

    override suspend fun create(): List<TaskInBoard> {
        return taskRepository.getAllTaskInBoardUseCase()
    }
}