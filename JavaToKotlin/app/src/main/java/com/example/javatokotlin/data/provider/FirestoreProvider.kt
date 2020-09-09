package com.example.javatokotlin.data.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.model.NoteResult
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreProvider : RemoteDataProvider {
    companion object {
        private const val NOTES_COLLECTION = "notes"
    }
    private val TAG = "${FirestoreProvider::class.java.simpleName} :"
    private val store = FirebaseFirestore.getInstance()
    private val notesReference = store.collection(NOTES_COLLECTION)

    override fun subscribeToAllNotes(): LiveData<NoteResult> {
        val result = MutableLiveData<NoteResult>()
        notesReference.addSnapshotListener { snapshot, e ->
            e?.let {
                result.value = NoteResult.Error(e)
            } ?: let {
                snapshot?.let {
                    val notes = snapshot.documents.map { doc ->
                        doc.toObject(Note::class.java)
                    }
                    result.value = NoteResult.Success(notes)
                }
            }
        }
        return result
    }

    override fun getNoteById(id: String): LiveData<NoteResult> {
        TODO("Not yet implemented")
    }

    override fun saveNote(note: Note): LiveData<NoteResult> {
        TODO("Not yet implemented")
    }
}