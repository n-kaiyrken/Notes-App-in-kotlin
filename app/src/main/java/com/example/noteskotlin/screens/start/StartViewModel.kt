package com.example.noteskotlin.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.noteskotlin.REPOSITORY
import com.example.noteskotlin.db.NoteDataBase
import com.example.noteskotlin.db.repository.NoteRepository
import com.example.noteskotlin.db.repository.NoteRepositoryImpl
import com.example.noteskotlin.model.NotesModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    private val context = application

    fun initDatabase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImpl(daoNote)
    }

    fun getAllNotes(): LiveData<List<NotesModel>>{
        return REPOSITORY.allNotes
    }
}