package com.lessthanthree.anything.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.lessthanthree.anything.database.NoteDao
import com.lessthanthree.anything.model.Note

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAll()
    val latestNotes: LiveData<List<Note>> = noteDao.getLatestNotes()
    val oldestNotes: LiveData<List<Note>> = noteDao.getOldestNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(note: Note) {
        noteDao.update(note)
    }

}