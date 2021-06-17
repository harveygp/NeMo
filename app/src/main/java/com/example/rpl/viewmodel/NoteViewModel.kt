package com.android.mailapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.rpl.database.NoteDatabase
import com.example.rpl.model.Notes
import com.example.rpl.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NoteRepository
    val listInbox: LiveData<List<Notes>>

    init {
       val mailDao = NoteDatabase.getDatabase(application).mailDao()
        repository = NoteRepository(mailDao)
        listInbox = repository.getInboxList
    }

    fun composeMail(mail: Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.composeMail(mail)
    }

    fun editMail(mail: Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.editMail(mail)
    }

    fun deleteMail(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteMail(id)
    }

}