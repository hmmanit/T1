package com.homanad.android.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.data.common.BaseDao
import com.homanad.android.data.db.entity.TaskEntity
import com.homanad.android.data.db.entity.relation.TaskInBoardEntity

@Dao
abstract class TaskDAO : BaseDao<TaskEntity> {

    @Query("SELECT * FROM TaskEntity")
    abstract suspend fun getTasks(): List<TaskEntity>

    @Query("SELECT * FROM TaskEntity")
    abstract suspend fun getTaskInBoards(): List<TaskInBoardEntity>

    @Query("SELECT * FROM TaskEntity WHERE startTime > :start AND endTime < :end")
    abstract suspend fun getTasksInDate(start: Long, end: Long): List<TaskInBoardEntity>
}