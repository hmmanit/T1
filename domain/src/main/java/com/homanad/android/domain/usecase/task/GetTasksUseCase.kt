package com.homanad.android.domain.usecase.task

import com.homanad.android.domain.common.UseCase
import com.homanad.android.domain.entity.Task
import com.homanad.android.domain.repository.TaskRepository

class GetTasksUseCase(
    private val taskRepository: TaskRepository
) : UseCase<List<Task>>() {

    override suspend fun create(): List<Task> {
        return taskRepository.getTasks()
    }
}