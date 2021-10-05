package com.example.universityapp.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityapp.model.Student
import com.example.universityapp.model.StudentRepo
import com.example.universityapp.model.StudentRepoVM
import kotlinx.coroutines.launch

class StudentViewModel(app:Application) : AndroidViewModel(app) {

    private val rapo = StudentRepoVM(app)
    var studentList = mutableListOf<Student>()

    init {
        updateList()
    }

    fun addStudent(std : Student){
        viewModelScope.launch {
            rapo.addStudent(std)
            updateList()
        }
    }

    fun deleteStudent(std : Student){
        viewModelScope.launch {
            rapo.deleteStudent(std)
            updateList()
        }

    }

    fun deleteAll(){
        viewModelScope.launch {
            rapo.deleteAllStudent()
            updateList()
        }
    }


//    fun updateStudent(std : Student){
//        viewModelScope.launch {
//            studentList = rapo.getAllStudents().toMutableList()
//        }
//    }

    fun updateList(){
        viewModelScope.launch {
            studentList = rapo.getAllStudents().toMutableList()
            Log.d("StudentViewModel","Update list")
        }
    }


}