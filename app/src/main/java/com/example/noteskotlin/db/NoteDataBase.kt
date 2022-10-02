package com.example.noteskotlin.db

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteskotlin.db.dao.NotesDao
import com.example.noteskotlin.model.NotesModel

@Database(entities = [NotesModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun getNoteDao(): NotesDao

    companion object{
        private var database: NoteDataBase ?=null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase{
            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                database as NoteDataBase
            } else {
                database as NoteDataBase
            }
        }
    }
}