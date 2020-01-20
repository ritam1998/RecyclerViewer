package com.qi.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.qi.student.ClassDetails.StudentClass
import com.qi.student.student.StudentActivity

class MainActivity : AppCompatActivity() {

    private var studentReg : Button ?= null
    private var classReg : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentReg = findViewById(R.id.student)

        studentReg?.setOnClickListener{
            startActivity(Intent(this, StudentActivity:: class.java))    // For student Registration
        }

        classReg = findViewById(R.id.classname)

        classReg?.setOnClickListener{
            startActivity(Intent(this, StudentClass:: class.java))
        }
    }
}
