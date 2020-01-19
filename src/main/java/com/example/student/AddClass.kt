package com.example.student

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddClass : AppCompatActivity(){

    var addClassButton : Button ?= null
    var addClassText : EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addclass)

        addClassButton = findViewById(R.id.saveclass)

        addClassButton?.setOnClickListener{
            addClassName()
        }
    }
    fun addClassName(){

        addClassText = findViewById(R.id.addclasstext)

        val classNameToString = addClassText?.text?.toString()

        val saveTheClass = ClassDatabaseHelper(this,null,null ,1)

        if(classNameToString.equals("")){
            Toast.makeText(this,"class name cannot be blank",Toast.LENGTH_LONG).show()
        } else {

            val status = saveTheClass.insertUserDetails(classNameToString)
            Toast.makeText(this,"Record Saved",Toast.LENGTH_LONG).show()

//            if(status > -1){
//                Toast.makeText(this,"Record Saved",Toast.LENGTH_LONG).show()
//            }
        }
    }
}