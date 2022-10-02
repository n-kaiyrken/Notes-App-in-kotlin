package com.example.noteskotlin.db.repository

import androidx.lifecycle.LiveData
import com.example.noteskotlin.model.NotesModel

interface NoteRepository {
    val allNotes : LiveData<List<NotesModel>>

    suspend fun insertNote(note: NotesModel, onSuccess:() -> Unit)

    suspend fun deleteNote(note: NotesModel, onSuccess:() -> Unit)
}