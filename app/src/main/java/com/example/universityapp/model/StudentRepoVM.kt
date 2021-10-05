package com.example.universityapp.model

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentRepoVM(val ctx : Context) {

    private val db = StudentDatabase.getInstance(ctx)
    private val dao = db.getStudentDao()

    suspend fun addStudent(std : Student) = dao.addStudent(std)

    suspend fun deleteStudent(std : Student) = dao.deleteStudent(std)

    suspend fun deleteAllStudent() = dao.deleteAll()

    suspend fun updateStd(std : Student) = dao.updateStudent(std)

    suspend fun getAllStudents(): List<Student>{
        // launch - fire anf forget
        // asynch - wait and result
        val deferredResult = CoroutineScope(Dispatchers.Default).async {
            dao.getStudents()
        }
        return deferredResult.await()
    }



}