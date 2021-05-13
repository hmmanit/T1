package com.homanad.android.data.repository.boardAndTasks.datasource

import com.homanad.android.data.db.dao.BoardAndTasksDAO
import com.homanad.android.data.mapper.toBoardAndTasks
import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import javax.inject.Inject

class BoardAndTasksDataSourceImpl @Inject constructor(
    private val boardAndTasksDAO: BoardAndTasksDAO
) : BoardAndTasksDataSource {

    override suspend fun getAllBoardAndTasks(): List<BoardAndTasks> {
        return boardAndTasksDAO.getAllBoardAndTasks().map { it.toBoardAndTasks() }
    }

    override suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasks {
        return boardAndTasksDAO.getBoardAndTasksById(boardId).toBoardAndTasks()
    }
}