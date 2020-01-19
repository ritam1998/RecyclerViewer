package com.example.student

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_listview_classname.*

class ClassNameActivity : AppCompatActivity() {

    private var recycleViewClassName : RecyclerView ?= null
    private var addClassButton : Button?= null

    companion object{
        lateinit var dbhandler : ClassDatabaseHelper
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classname)

        // getting recyclerview in xml
        //recycleViewClassName = findViewById(R.id.recyclerViewClass)

        // adding the layout manager
        //recycleViewClassName?.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)


        dbhandler = ClassDatabaseHelper(this,null,null,1)

        // creating an arraylist to store the class
        //val allClassName = ArrayList<AllClassName>()

//        val allClassName = ClassDatabaseHelper(this)
//        allClassName.add(AllClassName("Ritam"))
//        allClassName.add(AllClassName("Ritam"))

        // creating our adapter

        //val classAdapter = ClassNameAdapter(allclassname)
        // adding the adapter to recyclerview

//        recycleViewClassName?.adapter = classAdapter
//
//        addClassButton = findViewById(R.id.addclass)
        viewClass()
        addClassButton?.setOnClickListener{
            startActivity(Intent(this,AddClass :: class.java))
        }
    }
    private fun viewClass(){

        var classList = dbhandler.fetchClass(this)
        Log.v("check","index check list == $classList")
        var adapter = ClassNameAdapter(this,classList)
        var rv : RecyclerView = findViewById(R.id.recyclerViewClass)
        rv.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false) as RecyclerView.LayoutManager
        rv.adapter = adapter
        //var adapter = ClassNameAdapter(this,classlist)
    }
}