package com.example.rpl.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rpl.dao.MailDao
import com.example.rpl.model.Mail


@Database(
    entities = [Mail::class],
    version = 1,
    exportSchema = false
)
abstract class MailDatabase: RoomDatabase() {

    abstract fun mailDao(): MailDao

    companion object{
        @Volatile
        private var INSTANCE: MailDatabase? = null

        fun getDatabase(context: Context): MailDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MailDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}