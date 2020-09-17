package com.example.javatokotlin.data

import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.provider.DataProvider


class NotesRepository(val remoteProvider: DataProvider) {
    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
    fun deleteNote(id: String) = remoteProvider.deleteNote(id)
    fun getCurrentUser() = remoteProvider.getCurrentUser()
}