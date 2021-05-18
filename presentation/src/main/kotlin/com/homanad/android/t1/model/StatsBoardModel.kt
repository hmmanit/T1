package com.homanad.android.t1.model

import com.homanad.android.domain.entity.Board

data class StatsBoardModel(
    val board: Board,
    var statsStatusModel: List<StatsStatusModel>
)

data class StatsStatusModel(
    val status: Int,
    val count: Int
)