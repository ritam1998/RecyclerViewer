package com.example.student

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.util.prefs.PreferencesFactory
import com.example.student.AllClassName as AllClassName


class ClassDatabaseHelper(context : Context,name: String?,factory: SQLiteDatabase.CursorFactory?,version: Int) :
    SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object{

        var DATABASE_VERSION = 1
        var DATABASE_NAME = "StudentInfo"
        var TABLE_CLASSNAME = "classTable"
        var KEY_ID = "id"
        var CLASS_NAME = "classname"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        var createClassTable = ("CREATE TABLE "+ TABLE_CLASSNAME+"("+ KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ CLASS_NAME +"TEXT "+");")
        db?.execSQL(createClassTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("DROP TABLE IF EXISTS"+ {TABLE_CLASSNAME})
        onCreate(db)
    }

    /* Insert the class name*/

    fun insertUserDetails(classname: String?) {

        //Get the Data Repository in write mode
        val db = this.writableDatabase

        //Create a new map of values, where column names are the keys
        val cValues = ContentValues()

        cValues.put(CLASS_NAME, classname)

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert(TABLE_CLASSNAME, null, cValues)

        db.close()
    }

    fun fetchClass(context: Context): ArrayList<AllClassName>{

        var fetchClass = "SELECT * FROM $TABLE_CLASSNAME"

        var db = this.readableDatabase

        var cursor = db.rawQuery(fetchClass,null)


        var allclasslist = ArrayList<AllClassName>()

        if(cursor.count == 0){
            Toast.makeText(context,"No Record Found",Toast.LENGTH_LONG).show()
        } else {
            while(cursor.moveToNext()){

                var allclassname = AllClassName()
                allclassname.className = cursor.getString(cursor.getColumnIndex(CLASS_NAME))
                allclasslist.add(allclassname)
            }
            Toast.makeText(context,"All Records Found",Toast.LENGTH_LONG).show()
        }
        Log.v("check","list ===== $allclasslist")
        cursor.close()
        db.close()
        return allclasslist
    }
}