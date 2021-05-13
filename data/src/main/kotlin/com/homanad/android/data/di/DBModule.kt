package com.homanad.android.data.di

import android.content.Context
import androidx.room.Room
import com.homanad.android.data.db.TDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, TDatabase::class.java, TDatabase::class.java.simpleName)

    @Provides
    fun provideBoardDAO(tDatabase: TDatabase) = tDatabase.boardDAO

    @Provides
    fun provideTaskDAO(tDatabase: TDatabase) = tDatabase.taskDAO
}