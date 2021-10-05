package com.example.universityapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase(){

    abstract fun getStudentDao() : StudentDAO

    companion object{
        private var instance : StudentDatabase? = null         // if it is accessing first time then it will be null otherwise not null // and for null we made it null referencing variabke

        fun getInstance(context : Context) : StudentDatabase{
            if(instance == null){                // will go in this for first time only
                // create instance
                // for first time when it is null
                instance = createDatabase(context)
            }
            // for next time it won't go in if block
            return instance!!
        }

        private fun createDatabase(context : Context): StudentDatabase? {
            val builder = Room.databaseBuilder(context,
                StudentDatabase::class.java, "university.db")

            return builder.build()      // .build - creates data base and returns it's instance
        }
    }

}