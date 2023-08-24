package com.lovejeet.crud

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovejeet.crud.Entity.NotesEntity
import kotlinx.coroutines.launch

class NotesModel(application: Application) : AndroidViewModel(application) {

   private var notesDatabase : NotesDatabase
   var list: LiveData<List<NotesEntity>>

   init {
      notesDatabase = NotesDatabase.getDatabase(application)
      list = notesDatabase.notesDao().getNotes()
   }

   fun insertNotes(notesEntity: NotesEntity){
      viewModelScope.launch {
         notesDatabase.notesDao().InsertNotes(notesEntity)
      }
   }
}