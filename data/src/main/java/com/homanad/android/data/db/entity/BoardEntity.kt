package com.homanad.android.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BoardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1,
    val title: String = "",
    val description: String = "",
    val imagePath: String = ""
)