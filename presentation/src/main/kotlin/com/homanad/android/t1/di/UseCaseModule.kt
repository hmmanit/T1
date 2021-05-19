package com.homanad.android.t1.di

import com.homanad.android.domain.repository.BoardRepository
import com.homanad.android.domain.repository.TaskRepository
import com.homanad.android.domain.usecase.boardAndTasks.GetAllBoardAndTasksUseCase
import com.homanad.android.domain.usecase.task.CreateTaskUseCase
import com.homanad.android.domain.usecase.taskInBoard.GetAllTaskInBoardUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideCreateTaskUseCase(taskRepository: TaskRepository) = CreateTaskUseCase(taskRepository)

    @Provides
    fun provideGetAllBoardAndTasksUseCase(boardRepository: BoardRepository) =
        GetAllBoardAndTasksUseCase(boardRepository)

    @Provides
    fun provideGetAllTaskInBoardUseCase(taskRepository: TaskRepository) =
        GetAllTaskInBoardUseCase(taskRepository)
}