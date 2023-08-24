package com.lovejeet.crud.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Calendar

@Entity
data class NotesEntity(

    @PrimaryKey()
    var id : Int ?=null,
    var title: String?= null,
    var description: String?= null,
    var createdAt: String = SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().time)
){
    override fun toString(): String {
        return "$title"
    }
}