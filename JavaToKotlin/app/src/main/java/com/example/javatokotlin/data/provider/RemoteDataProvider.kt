package com.example.javatokotlin.data.provider

import androidx.lifecycle.LiveData
import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
}