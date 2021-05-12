package com.homanad.android.domain.repository

import com.homanad.android.domain.entity.Task

interface TaskRepository {
    suspend fun createTask(task: Task): Long
    suspend fun updateTask(task: Task): Int
    suspend fun deleteTask(task: Task): Int
    suspend fun getTasks(): List<Task>
}