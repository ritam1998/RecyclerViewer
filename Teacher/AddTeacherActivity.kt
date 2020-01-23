package com.example.student.Teacher

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.student.R
import com.example.student.subject.InsertSubject

class AddTeacherActivity : AppCompatActivity(){

    private var subjectposition : Int ?= 0
    private var teachername : EditText ?= null
    private var teacherphone : EditText ?= null
     var subjectname : String ?= null
    private var teachersavebutton : Button ?= null

     var subjectlist = InsertSubject(this)

    companion object{
        lateinit var insertTeacher: InsertTeacher
    }
    init {
        insertTeacher = InsertTeacher(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_addteacher)

        teachername = findViewById(R.id.teacherusername)
        teacherphone = findViewById(R.id.teacherphone)

        teachersavebutton = findViewById(R.id.teacherbutton)

        teachersavebutton?.setOnClickListener {
            addteacher()
            finish()
        }

        insertTeacher.open()

        subjectlist.read()

        var listofsubject = subjectlist.fetchSubject(this)

        val spin = findViewById(R.id.teacherspinner) as Spinner

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, listofsubject)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Setting the ArrayAdapter data on the Spinner
        spin.adapter = aa

        spin.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                subjectposition = position
                subjectname = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@AddTeacherActivity,"Selected "+ subjectname, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
    }

    fun addteacher(){

        var teachernametostring = teachername?.text?.toString()
        var teacherphonetostring = teacherphone?.text?.toString()

        if(teachernametostring.equals("") || teacherphonetostring.equals("")){
            Toast.makeText(this,"Please Fill Up",Toast.LENGTH_LONG).show()
        }else{
            var status = insertTeacher.insertTeacherData(this,teachername = teachernametostring,teacherphone = teacherphonetostring,subjectId = subjectposition)
        }
    }
}



