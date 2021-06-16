package com.example.rpl.repository

import androidx.lifecycle.LiveData
import com.example.rpl.dao.MailDao
import com.example.rpl.model.Mail

class MailRepository(
    private val mailDao: MailDao
) {

    val getInboxList: LiveData<List<Mail>> = mailDao.getEmailList()

    suspend fun composeMail(mail: Mail){
        mailDao.insert(mail)
    }

    suspend fun editMail(mail: Mail){
        mailDao.edit(mail)
    }

    suspend fun deleteMail(id: Int){
        mailDao.deleteMail(id)
    }

}