package com.homanad.android.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.data.common.BaseDao

@Dao
abstract class BoardDAO : BaseDao<BoardEntity> {

    @Query("SELECT * FROM BoardEntity")
    abstract suspend fun getBoards(): List<BoardEntity>
}