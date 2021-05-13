package com.homanad.android.domain.entity.datamodel

import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.entity.Task

data class BoardAndTasks(
    val board: Board,
    val tasks: List<Task>
)