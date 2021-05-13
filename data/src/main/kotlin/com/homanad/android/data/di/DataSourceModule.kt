package com.homanad.android.data.di

import com.homanad.android.data.repository.board.datasource.BoardDataSource
import com.homanad.android.data.repository.board.datasource.BoardDataSourceImpl
import com.homanad.android.data.repository.task.datasource.TaskDataSource
import com.homanad.android.data.repository.task.datasource.TaskDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindBoardDataSource(boardDataSourceImpl: BoardDataSourceImpl): BoardDataSource

    @Binds
    abstract fun bindTaskDataSource(taskDataSourceImpl: TaskDataSourceImpl): TaskDataSource
}