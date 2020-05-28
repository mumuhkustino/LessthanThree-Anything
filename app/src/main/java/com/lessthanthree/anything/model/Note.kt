package com.lessthanthree.anything.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "note_table")
data class Note (
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @NonNull @ColumnInfo(name = "date") var date: Date
) {
    @PrimaryKey(autoGenerate = true) @NonNull
    @ColumnInfo(name = "id") var id: Int = 0
}