package com.homanad.android.domain.entity

data class Task(
    val id: Long = -1,
    val boardId: Long = -1,
    val title: String = "",
    val description: String = "",
    val priority: Int = -1,
    val themeColor: String = "",
    val status: Int = -1,
    val startTime: Long = -1,
    val endTime: Long = -1,
    val images: List<String> = ArrayList()
)

enum class Priority(point: Int) {
    LOW(0), MEDIUM(1), HIGH(2)
}

enum class Status(status: Int) {
    TODO(0), IN_PROGRESS(1), DONE(2)
}