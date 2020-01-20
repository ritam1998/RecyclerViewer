package com.qi.student.student

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.qi.student.R

class StudentActivity : AppCompatActivity() {

    private var regStudent : Button?= null
    private var recyclerviewstudent : RecyclerView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_studentname)

        var action = supportActionBar
        action?.setDisplayHomeAsUpEnabled(true)
        action?.setDisplayShowHomeEnabled(true)

        regStudent = findViewById(R.id.studentaddbutton)

        recyclerviewstudent = findViewById(R.id.studentrecycleviewer)

        var studentdetails = ArrayList<StudentModel>()

        studentdetails.add(StudentModel("Ritam De","Barrackpore"))
        studentdetails.add(StudentModel("Shubham Roy","Agarpara"))

        var studentAdapter = StudentAdapter(studentdetails)
        recyclerviewstudent?.adapter = studentAdapter



        regStudent?.setOnClickListener{
            startActivity(Intent(this,AddStudentActivity :: class.java))
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}