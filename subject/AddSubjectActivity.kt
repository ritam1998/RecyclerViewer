package com.example.student.subject

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.student.R

class AddSubjectActivity : AppCompatActivity(){

    private var savesubjectbutton : Button?= null
    private var subjecttext : EditText ?= null

    companion object{
        lateinit var insertSubject : InsertSubject
    }
    init {
        insertSubject = InsertSubject(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_addsubject)

        var action = supportActionBar
        action?.setDisplayHomeAsUpEnabled(true)
        action?.setDisplayShowHomeEnabled(true)

        savesubjectbutton = findViewById(R.id.savesubjectbutton)

        subjecttext = findViewById(R.id.addsubjecttext)

        savesubjectbutton?.setOnClickListener {
            addsubject()
            finish()
        }
        insertSubject.open()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    fun addsubject(){

        var subjectTostring  = subjecttext?.text?.toString()

        if(subjectTostring.equals("")){
            Toast.makeText(this,"Please Fill Up",Toast.LENGTH_LONG).show()
        }else{
            var status = insertSubject.insertSubject(this,subjectname = subjectTostring)
        }
    }
}