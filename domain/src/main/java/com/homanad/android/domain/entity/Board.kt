package com.homanad.android.domain.entity

data class Board(
    val boardId: Long = -1,
    val boardTitle: String = "",
    val boardDescription: String = "",
    val boardThemeColor: String = "",
    val boardImage: String = ""
)