package com.example.student.subject

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.student.R

class SubjectRecyclerViewActivity : AppCompatActivity(){

    private  var addsubjectbutton : Button ?= null

    companion object{
        lateinit var insertSubject: InsertSubject
    }
    init {
        insertSubject = InsertSubject(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycleview_subject)


//        var subjectlist = ArrayList<SubjectModel>()
//
//        subjectlist.add(SubjectModel("English"))
//        subjectlist.add(SubjectModel("English"))
//
//
//        var subjectadapter = SubjectAdapter(subjectlist)
//
//        recyclerview.adapter = subjectadapter

        addsubjectbutton = findViewById(R.id.subjectaddbutton)

        addsubjectbutton?.setOnClickListener {
            startActivityForResult(Intent(this,AddSubjectActivity :: class.java),1)
        }

        var action = supportActionBar
        action?.setDisplayHomeAsUpEnabled(true)
        action?.setDisplayShowHomeEnabled(true)

        insertSubject.read()

        showsubject()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1){
            showsubject()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun showsubject(){

        var fetchsubjectdetail = insertSubject.fetchSubject(this)

        var subjectadapter = SubjectAdapter(fetchsubjectdetail)

        var recyclerview = findViewById(R.id.subjectrecycleviewer) as RecyclerView
        recyclerview.adapter = subjectadapter
    }
}