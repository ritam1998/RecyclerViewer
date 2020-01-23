package com.example.student.Teacher

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.student.R
import com.example.student.subject.InsertSubject

class TeacherMainActivity : AppCompatActivity(){

    private  var addteacherbutton : Button ?= null
    private var subjectposition : Int ?= 0
    private var subjectname : String ?= null

    companion object{
        lateinit var insertTeacher: InsertTeacher

        lateinit var insertSubject: InsertSubject
    }
    init {

        insertTeacher = InsertTeacher(this)

        insertSubject = InsertSubject(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_teacher)

        addteacherbutton = findViewById(R.id.teacheraddbutton)

        addteacherbutton?.setOnClickListener {
            startActivityForResult(Intent(this,AddTeacherActivity ::class.java),1)
        }

        insertTeacher.read()

        viewteacherlist()

        var action = supportActionBar
        action?.setDisplayHomeAsUpEnabled(true)
        action?.setDisplayShowHomeEnabled(true)

        insertSubject.read()

        var listofsubject = insertSubject.fetchSubject(this)

        val spin = findViewById(R.id.spinner) as Spinner

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, listofsubject)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Setting the ArrayAdapter data on the Spinner
        spin.adapter = aa

        spin.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                subjectposition = position
                subjectname = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@TeacherMainActivity,"Selected "+ subjectname, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 1){
            viewteacherlist()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun viewteacherlist(){

        var allteachername = insertTeacher.fetchTeacherDetails(this)
        var teacheradapter = TeacherAdapter(allteachername,object : TeacherAdapter.TeacherSelectedCallback{

            override fun onTeacherClicked(teacherModel: TeacherModel) {

//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                //startActivityForResult(Intent(this@TeacherMainActivity,))
            }
        })
        var teacherrecycleview = findViewById(R.id.teacherrecycleviewer) as RecyclerView
        teacherrecycleview?.adapter = teacheradapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}