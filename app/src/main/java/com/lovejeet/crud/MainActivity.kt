package com.lovejeet.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.lovejeet.crud.Entity.NotesEntity
import com.lovejeet.crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ArrayAdapter<NotesEntity>
    var notesList = ArrayList<NotesEntity>()
    lateinit var notesModel: NotesModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notesModel = ViewModelProvider(this)[NotesModel::class.java]
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notesList)
        binding.listView.adapter = adapter

        notesModel.list.observe(this){
            notesList.clear()
            notesList.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.fab.setOnClickListener {
            notesModel.insertNotes(NotesEntity(title = "Testing", description = "Testing Description"))
        }

    }
    }
