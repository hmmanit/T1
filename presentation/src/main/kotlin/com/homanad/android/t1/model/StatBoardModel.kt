package com.homanad.android.t1.model

import com.homanad.android.domain.entity.Board

data class StatBoardModel(
    val board: Board,
    var statStatusModel: List<StatStatusModel>
)

data class StatStatusModel(
    val status: Int,
    val count: Int
)