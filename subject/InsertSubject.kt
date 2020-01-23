package com.example.student.subject

import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.example.student.DatabaseHandler
import java.lang.Exception

class InsertSubject (context: Context) {

    companion object{

        private val DATABASE_NAME = "studentInfo.db"
        private val DATABASE_VERSION = 1

        var SUBJECT_NAME = "subjectname"

        internal val CREATE_SUBJECT_TABLE = "create table subject_detail(subject_id integer primary key autoincrement,$SUBJECT_NAME text)"

        lateinit var db : SQLiteDatabase

        lateinit var subjectHandler : DatabaseHandler
    }

    var ok : String = "Ok"

    val subjectInstance : SQLiteDatabase
        get() = db

    init {
        subjectHandler = DatabaseHandler(context, DATABASE_NAME,null, DATABASE_VERSION)
    }

    @Throws(SQLException::class)
    fun open() : InsertSubject {
        db = subjectHandler.writableDatabase
        return this
    }
    fun read() : InsertSubject{
        db = subjectHandler.readableDatabase
        return this
    }
    fun insertSubject(context: Context,subjectname : String?){

        try {

            var subjectContent = ContentValues()

            subjectContent.put("subjectname",subjectname)

            var result = db.insert("subject_detail",null,subjectContent)

            Log.v(ContentValues.TAG,"result =="+result)

            if(result > 0){
                Toast.makeText(context,"Subject Information Saved", Toast.LENGTH_LONG).show()
            }

        }catch (ex : Exception){
            Log.v("Insert Subject","Exception === "+ex)
        }
    }
    fun fetchSubject(context :Context) : ArrayList<SubjectModel>{

        var subjectlist = ArrayList<SubjectModel>()

        var allsubjectdata = "select * from subject_detail"

        var subjectcursor = db.rawQuery(allsubjectdata,null)

        if(subjectcursor.count == 0){
            Toast.makeText(context,"No Subject List Found",Toast.LENGTH_LONG).show()
        }else{
            while (subjectcursor.moveToNext()){
                var allsubjectname = SubjectModel(subjectcursor.getString(subjectcursor.getColumnIndex(
                    SUBJECT_NAME)))
                subjectlist.add(allsubjectname)
            }
            Toast.makeText(context,"ALL SUBJECT RECORD FOUND",Toast.LENGTH_LONG).show()
        }
        subjectcursor.close()
        db.close()
        return subjectlist
    }
}