package com.homanad.android.domain.entity.datamodel

data class TaskInBoard(
    val taskId: Long = -1,
    val boardId: Long = -1,
    val taskTitle: String = "",
    val taskDescription: String = "",
    val priority: Int = -1,
    val themeColor: String = "",
    val status: Int = -1,
    val startTime: Long = -1,
    val endTime: Long = -1,
    val images: List<String> = ArrayList(),
    val boardTitle: String = ""
)