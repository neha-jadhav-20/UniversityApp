package com.example.universityapp.model

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentRepo(val ctx : Context) {

    private val db = StudentDatabase.getInstance(ctx)
    private val dao = db.getStudentDao()

    fun addStudent(std : Student){    //
        CoroutineScope(Dispatchers.Default).launch {
            dao.addStudent(std)
        }

    }

    fun deleteStudent(std : Student){
        CoroutineScope(Dispatchers.Default).launch {
            dao.deleteStudent(std)
        }
    }

    fun deleteAllStudent(){

        CoroutineScope(Dispatchers.Default).launch {
            dao.deleteAll()
        }

    }

    fun updateStd(std : Student){

        CoroutineScope(Dispatchers.Default).launch {
            dao.updateStudent(std)
        }
    }

    suspend fun getAllStudents(): List<Student>{
        // launch - fire anf forget
        // asynch - wait and result
        val deferredResult = CoroutineScope(Dispatchers.Default).async {
            dao.getStudents()
        }
        return deferredResult.await()
    }



}