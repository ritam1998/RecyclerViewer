package com.qi.student.student

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.qi.student.R
import com.qi.student.student.StudentAdapter.*

class StudentAdapter(val studentModelList: ArrayList<StudentModel>) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder, position: Int) {

        /* TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/
        holder.bindStudentList(studentModelList[position])
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.StudentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.listview_studentname, parent, false)
        return StudentViewHolder(v)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {

        Log.d("hello","checking purpose ")
        Log.v(ContentValues.TAG, "student list size=" + studentModelList.size)
        return studentModelList.size
    }

    class StudentViewHolder(val itView : View) : RecyclerView.ViewHolder(itView) {

        var username  = itView.findViewById(R.id.Username) as TextView
        var address  = itView.findViewById(R.id.ViewAdress) as TextView

        fun bindStudentList(studentModel : StudentModel){

            username.text = studentModel.name
            address.text = studentModel.address
        }
    }

}
