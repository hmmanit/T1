package com.homanad.android.domain.entity

data class Task(
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

enum class Priority(point: Int) {
    LOW(0), MEDIUM(1), HIGH(2)
}

enum class Status(status: Int) {
    TODO(0), IN_PROGRESS(1), DONE(2)
}