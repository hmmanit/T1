package com.homanad.android.domain.usecase.task

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.Task
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import com.homanad.android.domain.repository.TaskRepository

class GetTaskInDateUseCase(private val taskRepository: TaskRepository) :
    UseCaseWithParam<Long, List<TaskInBoard>>() {

    override suspend fun create(param: Long): List<TaskInBoard> {
        return taskRepository.getTasksInDate(param)
    }
}