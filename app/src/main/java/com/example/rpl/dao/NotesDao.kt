package com.example.rpl.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rpl.model.Notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM mail_list ORDER BY emailDate DESC")
    fun getEmailList(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(email: Notes)

    @Query("DELETE FROM mail_list WHERE id =:id")
    suspend fun deleteMail(id: Int)

    @Update
    suspend fun edit(email: Notes)

}