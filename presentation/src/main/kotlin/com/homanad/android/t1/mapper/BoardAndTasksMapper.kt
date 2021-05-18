package com.homanad.android.t1.mapper

import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.t1.model.StatBoardModel
import com.homanad.android.t1.model.StatStatusModel

fun BoardAndTasks.getStatusSet(): Set<Int> {
    val set = mutableSetOf<Int>()
    tasks.forEach {
        set.add(it.status)
    }
    return set
}

fun BoardAndTasks.getStatsBoardModel(): StatBoardModel {
    val statuses = mutableListOf<StatStatusModel>()
    getStatusSet().forEach { status ->
        var count = 0
        tasks.forEach {
            if (it.status == status) count++
        }
        statuses.add(StatStatusModel(status, count))
    }
    return StatBoardModel(board, statuses)
}