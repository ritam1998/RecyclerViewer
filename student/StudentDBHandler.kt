package com.qi.student.student

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.qi.student.student.InsertStudentDetail.Companion.DATABASE_NAME
import com.qi.student.student.InsertStudentDetail.Companion.DATABASE_VERSION

class StudentDBHandler (context: Context,name : String?,factory: SQLiteDatabase.CursorFactory?,version: Int) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        /*TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/
    }

    override fun onCreate(db: SQLiteDatabase?) {
        /*TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/
    }

}