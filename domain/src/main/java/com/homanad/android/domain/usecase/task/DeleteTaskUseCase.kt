package com.homanad.android.domain.usecase.task

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.Task
import com.homanad.android.domain.repository.TaskRepository

class DeleteTaskUseCase(
    private val taskRepository: TaskRepository
) : UseCaseWithParam<Task, Int>() {

    override suspend fun create(param: Task): Int {
        return taskRepository.deleteTask(param)
    }
}