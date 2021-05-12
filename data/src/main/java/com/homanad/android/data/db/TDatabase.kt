package com.homanad.android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.homanad.android.data.db.converter.ArrayConverter
import com.homanad.android.data.db.dao.BoardAndTasksDAO
import com.homanad.android.data.db.dao.BoardDAO
import com.homanad.android.data.db.dao.TaskDAO
import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.data.db.entity.TaskEntity

@Database(entities = [BoardEntity::class, TaskEntity::class], exportSchema = true, version = 1)
@TypeConverters(ArrayConverter::class)
abstract class TDatabase : RoomDatabase() {
    abstract val boardDAO: BoardDAO
    abstract val taskDAO: TaskDAO
    abstract val boardAndTasksDAO: BoardAndTasksDAO
}