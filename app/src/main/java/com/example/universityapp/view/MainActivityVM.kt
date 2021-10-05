package com.example.universityapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.universityapp.R
import com.example.universityapp.ViewModel.StudentViewModel
import com.example.universityapp.model.Student
import com.example.universityapp.model.StudentRepo
import com.example.universityapp.model.StudentRepoVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityVM : AppCompatActivity() {

    lateinit var rView : RecyclerView
    var stdAdapter : StudentAdapter? = null
    lateinit var vModel : StudentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rView = findViewById(R.id.studentL)
        rView.layoutManager = LinearLayoutManager(this)

        // do not do this
        // vModel = StudentViewModel(application)

        vModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(StudentViewModel::class.java)        // lets ypu decide wether to create it or use existing

        loadList()
    }

    override fun onResume() {
        super.onResume()
        loadList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Add Student")
        menu?.add("Delete All")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Add Student" ->{
                val i = Intent(this, AddStudentActivity::class.java)
                startActivity(i)
            }
            "Delete All" ->{
                vModel.deleteAll()
                loadList()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun loadList(){
       // vModel.updateList()
        stdAdapter = StudentAdapter(vModel.studentList)
        rView.adapter = stdAdapter
    }
}