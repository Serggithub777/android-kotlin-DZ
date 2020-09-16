package com.example.javatokotlin.data

import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.provider.FirestoreDataProvider
import com.example.javatokotlin.data.provider.DataProvider

object NoteRepository {
    val PROVIDER: DataProvider = FirestoreDataProvider()

    fun getNotes() = PROVIDER.subscribeToAllNotes()
    fun saveNote(note: Note) = PROVIDER.saveNote(note)
    fun getNoteById(id: String) = PROVIDER.getNoteById(id)
    fun getCurrentUser() = PROVIDER.getCurrentUser()
}