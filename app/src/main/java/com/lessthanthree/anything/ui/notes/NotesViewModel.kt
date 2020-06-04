package com.lessthanthree.anything.ui.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lessthanthree.anything.database.AnythingDatabase
import com.lessthanthree.anything.model.Note
import com.lessthanthree.anything.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val notesRepository: NotesRepository
    val allNotes: LiveData<List<Note>>

    init {
        val notesDao = AnythingDatabase.getDatabase(application).noteDao()
        notesRepository = NotesRepository(notesDao)
        allNotes = notesRepository.allNotes
    }

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        notesRepository.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        notesRepository.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        notesRepository.delete(note)
    }
}
