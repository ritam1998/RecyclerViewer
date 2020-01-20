package com.qi.student.student

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class InsertStudentDetail(context: Context){

    companion object{
        internal  val DATABASE_NAME = "StudentInformation.db"
        internal val DATABASE_VERSION = 1
        internal val DATABASE_CREATE_STUDENT_DETAILS =
            "create table student_details(student_id integer primary key autoincrement,username text,email text,phone text,pincode text,class text,address text,password text)"

        lateinit var db : SQLiteDatabase

        lateinit var studentDBHandler : InsertStudentDetail
    }
}