package com.homanad.android.domain.usecase.task

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.Task
import com.homanad.android.domain.repository.TaskRepository

class CreateTaskUseCase(
    private val taskRepository: TaskRepository
) : UseCaseWithParam<Task, Long>() {

    override suspend fun create(param: Task): Long {
        return taskRepository.createTask(param)
    }
}