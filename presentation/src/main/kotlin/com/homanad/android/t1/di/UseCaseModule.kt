package com.homanad.android.t1.di

import com.homanad.android.domain.repository.BoardAndTaskRepository
import com.homanad.android.domain.repository.TaskRepository
import com.homanad.android.domain.usecase.boardAndTasks.GetAllBoardAndTasksUseCase
import com.homanad.android.domain.usecase.task.GetAllTaskInBoardUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetAllBoardAndTasksUseCase(boardAndTaskRepository: BoardAndTaskRepository) =
        GetAllBoardAndTasksUseCase(boardAndTaskRepository)

    @Provides
    fun provideGetAllTaskInBoardUseCase(taskRepository: TaskRepository) =
        GetAllTaskInBoardUseCase(taskRepository)
}