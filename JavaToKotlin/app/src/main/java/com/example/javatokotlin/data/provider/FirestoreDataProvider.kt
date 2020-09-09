package com.example.javatokotlin.data.provider

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.model.NoteResult
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreDataProvider : RemoteDataProvider {
    companion object {
        private const val NOTES_COLLECTION = "notes"
    }
    private val TAG = "${FirestoreDataProvider::class.java.simpleName} :"
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
        val result = MutableLiveData<NoteResult>()
        notesReference.document(id).get()
                .addOnSuccessListener { snapshot ->
                    result.value = NoteResult.Success(snapshot.toObject(Note::class.java))
                }.addOnFailureListener {
                    result.value = NoteResult.Error(it)
                }
        return result
    }

    override fun saveNote(note: Note): LiveData<NoteResult> {
        val result = MutableLiveData<NoteResult>()
        notesReference.document(note.id).set(note)
                .addOnSuccessListener { snapshot ->
                    result.value = NoteResult.Success(note)
                    Log.d(TAG, "Note $note is saved")
                }.addOnFailureListener {
                    result.value = NoteResult.Error(it)
                    Log.d(TAG, "Error saving note $note")
                }
        return result
    }
}