package com.homanad.android.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BoardEntity(
    @PrimaryKey(autoGenerate = true)
    val boardId: Long = -1,
    val boardTitle: String = "",
    val boardDescription: String = "",
    val boardThemeColor: String = "",
    val boardImage: String = ""
)