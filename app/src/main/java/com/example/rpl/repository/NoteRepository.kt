package com.example.rpl.repository

import androidx.lifecycle.LiveData
import com.example.rpl.dao.NotesDao
import com.example.rpl.model.Notes

class NoteRepository(
    private val mailDao: NotesDao
) {

    val getInboxList: LiveData<List<Notes>> = mailDao.getEmailList()

    suspend fun composeMail(mail: Notes){
        mailDao.insert(mail)
    }

    suspend fun editMail(mail: Notes){
        mailDao.edit(mail)
    }

    suspend fun deleteMail(id: Int){
        mailDao.deleteMail(id)
    }

}