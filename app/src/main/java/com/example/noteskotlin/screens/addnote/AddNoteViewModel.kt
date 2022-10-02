package com.example.noteskotlin.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteskotlin.REPOSITORY
import com.example.noteskotlin.model.NotesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {
    fun insert(note: NotesModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(note) {
                onSuccess()
            }
        }

    }
