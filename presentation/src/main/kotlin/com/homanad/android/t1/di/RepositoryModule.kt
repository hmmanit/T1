package com.homanad.android.t1.di

import com.homanad.android.data.repository.board.BoardRepositoryImpl
import com.homanad.android.data.repository.task.TaskRepositoryImpl
import com.homanad.android.domain.repository.BoardRepository
import com.homanad.android.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBoardRepository(boardRepositoryImpl: BoardRepositoryImpl): BoardRepository

    @Binds
    abstract fun bindTaskRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository
}