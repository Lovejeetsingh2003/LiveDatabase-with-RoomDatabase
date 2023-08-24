package com.lovejeet.crud

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lovejeet.crud.Entity.NotesEntity

@Dao
interface NotesDao {

    @Insert
    suspend fun InsertNotes(notesEntity: NotesEntity)


    @Query("SELECT * FROM NotesEntity")
    fun getNotes() : LiveData<List<NotesEntity>>
}