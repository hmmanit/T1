package com.homanad.android.t1.common

import com.homanad.android.domain.entity.type.Priority
import com.homanad.android.domain.entity.type.Status
import com.homanad.android.t1.model.PriorityModel
import com.homanad.android.t1.model.StatusModel

val priorities = listOf(
    PriorityModel(Priority.LOW.point, "Low", "#FF4CAF50"),
    PriorityModel(Priority.MEDIUM.point, "Medium", "#FFFFC107"),
    PriorityModel(Priority.HIGH.point, "High", "#F44336"),
)

val statuses = listOf(
    StatusModel(Status.TODO.status, "To Do", "#FFFFC107"),
    StatusModel(Status.IN_PROGRESS.status, "In Progress", "#FF03A9F4"),
    StatusModel(Status.DONE.status, "Done", "#FF4CAF50"),
)

fun getPriorityByPoint(point: Int): PriorityModel {
    priorities.forEach {
        if (it.point == point) return it
    }
    return PriorityModel()
}

fun getStatusByStatus(status: Int): StatusModel {
    statuses.forEach {
        if (it.status == status) return it
    }
    return StatusModel()
}