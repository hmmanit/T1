package com.homanad.android.data.repository.taskInBoard.datasource

import com.homanad.android.data.db.dao.TaskDAO
import com.homanad.android.data.mapper.toTaskInBoard
import com.homanad.android.domain.entity.datamodel.TaskInBoard
import javax.inject.Inject

class TaskInBoardDataSourceImpl @Inject constructor(
    private val taskDAO: TaskDAO
) : TaskInBoardDataSource {

    override suspend fun getAllTaskInBoardUseCase(): List<TaskInBoard> {
        return taskDAO.getTaskInBoards().map { it.toTaskInBoard() }
    }
}