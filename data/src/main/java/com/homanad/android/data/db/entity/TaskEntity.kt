package com.homanad.android.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val boardId: Long,
    val title: String,
    val description: String,
    val priority: Int,
    val themeColor: String,
    val status: Int,
    val startTime: Long,
    val endTime: Long,
    val images: List<String>//paths
)