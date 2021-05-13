package com.homanad.android.data.repository.task.datasource

import com.homanad.android.domain.entity.Task

interface TaskDataSource {
    suspend fun createTask(task: Task): Long
    suspend fun updateTask(task: Task): Int
    suspend fun deleteTask(task: Task): Int
    suspend fun getTasks(): List<Task>
}