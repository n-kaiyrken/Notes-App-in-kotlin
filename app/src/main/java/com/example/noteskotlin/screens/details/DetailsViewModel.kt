package com.example.noteskotlin.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteskotlin.REPOSITORY
import com.example.noteskotlin.model.NotesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {
    fun delete(note: NotesModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(note) {
                onSuccess()
            }
        }
}