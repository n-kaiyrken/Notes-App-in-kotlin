package com.example.noteskotlin.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteskotlin.model.NotesModel

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notesModel: NotesModel)

    @Delete
    suspend fun delete(notesModel: NotesModel)

    @Query("SELECT * FROM note_table")
    fun getAllNotes() : LiveData<List<NotesModel>>
}