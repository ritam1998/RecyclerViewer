package com.example.student.Teacher

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.widget.Toast
import com.example.student.DatabaseHandler
import java.sql.SQLException

class InsertTeacher(context: Context) {


    internal var ok = "OK"

    /* method returns an Instance of the database*/
    val studentdatabaseInstance: SQLiteDatabase
        get() = db

    init {
        teacherDBHandler = DatabaseHandler(context, DATABASE_NAME,null, DATABASE_VERSION)

        //addTeacherActivity = AddTeacherActivity()
    }
    //var addTeacherActivity = AddTeacherActivity()

    /* Method to open tha database*/

    @Throws(SQLException::class)
    fun open(): InsertTeacher {
        db = teacherDBHandler.writableDatabase
        return this
    }
    fun read():InsertTeacher{
        db = teacherDBHandler.readableDatabase
        return this
    }

    fun insertTeacherData(context: Context,teachername: String?,teacherphone: String?,subjectId: Int?) {

        try {
            Log.v("insert Teacher", "teacher details")

            var addnewvalues = ContentValues()

            addnewvalues.put("teachername", teachername)
            addnewvalues.put("phone", teacherphone)
            addnewvalues.put("subject", subjectId)

            val result = db.insert("teacher_detail", null, addnewvalues)

            Log.v("insert Teacher", "teacher details" + result)

            if(result > 0){
                Toast.makeText(context, "Teacher Info Saved", Toast.LENGTH_LONG).show()
            }
        } catch (error: Exception) {

        }
    }

    fun fetchTeacherDetails(context: Context): ArrayList<TeacherModel> {

        var teacherdetail = "select * from teacher_detail"

        var teacherCursor = db.rawQuery(teacherdetail, null)

        var teacherlist = ArrayList<TeacherModel>()


        if (teacherCursor.count == 0) {
            Toast.makeText(context, "No Teacher Details Found", Toast.LENGTH_LONG).show()
        } else {
            while (teacherCursor.moveToNext()) {

                var teacher_details = TeacherModel()

                teacher_details.teacherId = teacherCursor.getInt(teacherCursor.getColumnIndex("teacher_id"))
                teacher_details.teachername = teacherCursor.getString(teacherCursor.getColumnIndex(TEACHERNAME))
                teacher_details.phonenumber = teacherCursor.getString(teacherCursor.getColumnIndex(TEACHERPHONE))
                //teacher_details.subjectname = addTeacherActivity.subjectname

                teacherlist.add(teacher_details)
            }
            Toast.makeText(context, "All Teacher details found", Toast.LENGTH_LONG).show()
        }
        Log.v("student data", "Student ==== $teacherlist")
        teacherCursor.close()
        db.close()
        return teacherlist
    }

    companion object {
        internal val DATABASE_NAME = "studentInfo.db"
        internal val DATABASE_VERSION = 1
        var TEACHERNAME = "teachername"
        var TEACHERPHONE = "phone"
        var SUBJECTID = "subject"
        var SUBJECTNAME = "subjectname"

        internal val DATABASE_CREATE_TEACHER_DETAILS =
            "create table teacher_detail(teacher_id integer primary key autoincrement,$TEACHERNAME text,$TEACHERPHONE text,$SUBJECTID integer)"

        lateinit var db: SQLiteDatabase

        lateinit var teacherDBHandler: DatabaseHandler

        //lateinit var addTeacherActivity: AddTeacherActivity
    }
}
