package com.homanad.android.t1.mapper

import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.t1.model.StatsBoardModel
import com.homanad.android.t1.model.StatsStatusModel

fun BoardAndTasks.getStatusSet(): Set<Int> {
    val set = mutableSetOf<Int>()
    tasks.forEach {
        set.add(it.status)
    }
    return set
}

fun BoardAndTasks.getStatsBoardModel(): StatsBoardModel {
    val statuses = mutableListOf<StatsStatusModel>()
    getStatusSet().forEach { status ->
        var count = 0
        tasks.forEach {
            if (it.status == status) count++
        }
        statuses.add(StatsStatusModel(status, count))
    }
    return StatsBoardModel(board, statuses)
}