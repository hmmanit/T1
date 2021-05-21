package com.homanad.android.data.db

import com.homanad.android.data.db.entity.TaskEntity
import com.homanad.android.domain.entity.type.Priority
import com.homanad.android.domain.entity.type.Status

val tasks = listOf(
    TaskEntity(0, 1, "Morning", "Morning 1", Priority.LOW.point, "", Status.TODO.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf()),
    TaskEntity(0, 1, "Morning", "Morning 1", Priority.LOW.point, "", Status.IN_PROGRESS.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf()),
    TaskEntity(0, 1, "Morning", "Morning 1", Priority.LOW.point, "", Status.DONE.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf()),
    TaskEntity(0, 1, "Morning", "Morning 1", Priority.LOW.point, "", Status.IN_PROGRESS.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf()),
    TaskEntity(0, 1, "Morning", "Morning 1", Priority.LOW.point, "", Status.IN_PROGRESS.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf()),
    TaskEntity(0, 2, "Morning", "Morning 1", Priority.LOW.point, "", Status.TODO.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf()),
    TaskEntity(0, 2, "Morning", "Morning 1", Priority.LOW.point, "", Status.IN_PROGRESS.status, System.currentTimeMillis(), System.currentTimeMillis() + 86400000, listOf())
)