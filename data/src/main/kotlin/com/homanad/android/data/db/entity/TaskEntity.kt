package com.homanad.android.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val taskId: Long = -1,
    val boardId: Long = -1,
    val taskTitle: String = "",
    val taskDescription: String = "",
    val priority: Int = -1,
    val taskThemeColor: String = "",
    val status: Int = -1,
    val startTime: Long = -1,
    val endTime: Long = -1,
    val images: List<String> = ArrayList()
)