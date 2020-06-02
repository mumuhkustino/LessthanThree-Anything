package com.lessthanthree.anything.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "note_table")
data class Note (
    @ColumnInfo(name = "description") var description: String?,
    @NonNull @ColumnInfo(name = "date") var date: Date
) : Parcelable {
    @PrimaryKey(autoGenerate = true) @NonNull
    @ColumnInfo(name = "id") var id: Int = 0
}