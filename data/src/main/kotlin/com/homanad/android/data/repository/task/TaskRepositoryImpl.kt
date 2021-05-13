package com.homanad.android.data.repository.task

import com.homanad.android.data.repository.task.datasource.TaskDataSource
import com.homanad.android.domain.entity.Task
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import com.homanad.android.domain.repository.TaskRepository
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDataSource: TaskDataSource
) : TaskRepository {

    override suspend fun createTask(task: Task): Long {
        return taskDataSource.createTask(task)
    }

    override suspend fun updateTask(task: Task): Int {
        return taskDataSource.updateTask(task)
    }

    override suspend fun deleteTask(task: Task): Int {
        return taskDataSource.deleteTask(task)
    }

    override suspend fun getTasks(): List<Task> {
        return taskDataSource.getTasks()
    }

    override suspend fun getAllTaskInBoardUseCase(): List<TaskInBoard> {
        return taskDataSource.getAllTaskInBoardUseCase()
    }
}