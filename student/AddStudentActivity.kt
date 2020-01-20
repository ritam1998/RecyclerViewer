package com.qi.student.student

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.qi.student.R
import android.view.View
import android.widget.AdapterView
import android.R.attr.country
import android.util.Log
import android.widget.ArrayAdapter
import com.qi.student.ClassDetails.ClassNameAdapter
import com.qi.student.ClassDetails.InsertClassData
import com.qi.student.ClassDetails.StudentClass


class AddStudentActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {




    private var spinnerclassname : Spinner ?= null

    lateinit var insertClass : InsertClassData



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        insertClass = InsertClassData(this)

        var action = supportActionBar
        action?.setDisplayHomeAsUpEnabled(true)
        action?.setDisplayShowHomeEnabled(true)

       var listofclass = insertClass.fetchData(this)


       Log.v("check","index check list == $listofclass")

        /* Add Spinner Class*/

        val spin = findViewById(R.id.spinnerClass) as Spinner
        spin.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, listofclass)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Setting the ArrayAdapter data on the Spinner
        spin.adapter = aa


    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        /* TODO("not implemented") //To change body of created functions use File | Settings | File Templates. */

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

        /* TODO("not implemented") //To change body of created functions use File | Settings | File Templates. */
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}