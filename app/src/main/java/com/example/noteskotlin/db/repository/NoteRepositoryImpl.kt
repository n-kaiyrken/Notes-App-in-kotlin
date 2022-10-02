package com.example.noteskotlin.db.repository

import androidx.lifecycle.LiveData
import com.example.noteskotlin.db.dao.NotesDao
import com.example.noteskotlin.model.NotesModel

class NoteRepositoryImpl(private val notesDao: NotesDao) : NoteRepository{
    override val allNotes: LiveData<List<NotesModel>>
        get() = notesDao.getAllNotes()

    override suspend fun insertNote(note: NotesModel, onSuccess: () -> Unit) {
        notesDao.insert(note)
        onSuccess()
    }

    override suspend fun deleteNote(note: NotesModel, onSuccess: () -> Unit) {
        notesDao.delete(note)
        onSuccess()
    }
}