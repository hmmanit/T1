package com.homanad.android.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.homanad.android.data.db.TDatabase
import com.homanad.android.data.db.boards
import com.homanad.android.data.db.dao.BoardDAO
import com.homanad.android.data.db.dao.TaskDAO
import com.homanad.android.data.db.tasks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
        boardDaoProvider: Provider<BoardDAO>,
        taskDaoProvider: Provider<TaskDAO>
    ) = Room.databaseBuilder(context, TDatabase::class.java, TDatabase::class.java.simpleName)
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    boardDaoProvider.get().insert(boards)
                    taskDaoProvider.get().insert(tasks)
                }
            }
        }).build()

    @Provides
    fun provideBoardDAO(tDatabase: TDatabase) = tDatabase.boardDAO

    @Provides
    fun provideTaskDAO(tDatabase: TDatabase) = tDatabase.taskDAO

    @Provides
    fun provideBoardAndTasksDAO(tDatabase: TDatabase) = tDatabase.boardAndTasksDAO
}