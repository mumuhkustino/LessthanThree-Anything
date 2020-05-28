package com.lessthanthree.anything.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lessthanthree.anything.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAll(): LiveData<List<Note>>

    @Query("SELECT * FROM note_table ORDER BY date ASC")
    fun getOldestNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note_table ORDER BY date DESC")
    fun getLatestNotes(): LiveData<List<Note>>

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

}