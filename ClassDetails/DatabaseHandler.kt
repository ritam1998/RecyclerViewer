package com.qi.student.ClassDetails

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.qi.student.ClassDetails.InsertClassData.Companion.DATABASE_CREATE_ClASS
import com.qi.student.ClassDetails.InsertClassData.Companion.DATABASE_NAME
import com.qi.student.ClassDetails.InsertClassData.Companion.DATABASE_VERSION

class DatabaseHandler(context: Context,name : String?,factory: SQLiteDatabase.CursorFactory?,version: Int) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        /* TODO("not implemented") //To change body of created functions use File | Settings | File Templates. */
        db!!.execSQL("DROP TABLE IF EXISTS $DATABASE_CREATE_ClASS")
        // Create a new one.
        onCreate(db)
    }
    override fun onCreate(db: SQLiteDatabase?) {

        /* TODO("not implemented") //To change body of created functions use File | Settings | File Templates. */
        try {
            db?.execSQL(DATABASE_CREATE_ClASS)
        } catch (er: Exception) {
            Log.e("Error", "exceptioin")
        }
    }
}