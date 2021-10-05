package com.example.universityapp.model

import androidx.room.*


@Dao
interface StudentDAO {
    // only methods for performing SQL operation

    @Insert
    suspend fun addStudent(std : Student)  // method created here

    @Update
    suspend fun updateStudent(std : Student)

    @Delete
    suspend fun deleteStudent(std : Student)

    @Query("delete from students")
    suspend fun deleteAll()

    @Query("select * from students order by marks desc")
    suspend fun getStudents(): List<Student>

}