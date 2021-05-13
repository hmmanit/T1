package com.homanad.android.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.data.db.entity.TaskEntity
import com.homanad.android.data.common.BaseDao

@Dao
abstract class TaskDAO : BaseDao<TaskEntity> {

    @Query("SELECT * FROM TaskEntity")
    abstract suspend fun getTasks(): List<TaskEntity>
}