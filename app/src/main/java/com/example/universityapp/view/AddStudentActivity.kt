package com.example.universityapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.universityapp.R
import com.example.universityapp.ViewModel.StudentViewModel
import com.example.universityapp.model.Student
import com.example.universityapp.model.StudentRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddStudentActivity : AppCompatActivity() {
//    lateinit var repo : StudentRepo

    lateinit var vModel : StudentViewModel
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var marksEditText: EditText
    lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

//        repo = StudentRepo(this)

        firstNameEditText = findViewById(R.id.fnameE)
        lastNameEditText = findViewById(R.id.lnameE)
        marksEditText = findViewById(R.id.marksE)
        addButton = findViewById(R.id.addB)

        vModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(StudentViewModel::class.java)


    }

    fun addClick(view: View) {
        val fname = firstNameEditText.text.toString()
        val lname = lastNameEditText.text.toString()
        val marks = marksEditText.text.toString()
        if(fname.isNotEmpty() && lname.isNotEmpty() && marks.isNotEmpty()){
//            repo.addStudent(Student(fname,lname,marks.toInt()))
            vModel.addStudent(Student(fname,lname,marks.toInt()))
            finish()
        }
        else
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show()

    }

}