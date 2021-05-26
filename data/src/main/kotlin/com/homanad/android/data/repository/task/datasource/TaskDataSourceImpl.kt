package com.homanad.android.data.repository.task.datasource

import android.util.Log
import com.homanad.android.domain.common.getEndOfToday
import com.homanad.android.domain.common.getStartOfToday
import com.homanad.android.data.db.dao.TaskDAO
import com.homanad.android.data.mapper.toTask
import com.homanad.android.data.mapper.toTaskEntity
import com.homanad.android.data.mapper.toTaskInBoard
import com.homanad.android.domain.entity.Task
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import javax.inject.Inject

class TaskDataSourceImpl @Inject constructor(private val taskDAO: TaskDAO) : TaskDataSource {

    override suspend fun createTask(task: Task): Long {
        return taskDAO.insert(task.toTaskEntity())
    }

    override suspend fun updateTask(task: Task): Int {
        return taskDAO.update(task.toTaskEntity())
    }

    override suspend fun deleteTask(task: Task): Int {
        return taskDAO.delete(task.toTaskEntity())
    }

    override suspend fun getTasks(): List<Task> {
        return taskDAO.getTasks().map { it.toTask() }
    }

    override suspend fun getAllTaskInBoardUseCase(): List<TaskInBoard> {
        return taskDAO.getTaskInBoards().map { it.toTaskInBoard() }
    }

    override suspend fun getTasksInDate(millis: Long): List<TaskInBoard> {
        val start = millis.getStartOfToday()
        val end = millis.getEndOfToday()
        Log.d("abcstart", start.toString())
        Log.d("abcend", end.toString())
        return taskDAO.getTasksInDate(start, end).map { it.toTaskInBoard() }
    }
}