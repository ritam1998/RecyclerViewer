package com.example.student.Teacher

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.student.R

class TeacherAdapter(val teacherModelList: ArrayList<TeacherModel>, val teacherSelectedCallback: TeacherSelectedCallback)
    : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    override fun onBindViewHolder(holder: TeacherAdapter.TeacherViewHolder, position: Int) {

        /* TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/
        holder.bindTeacherList(teacherModelList[position])
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherAdapter.TeacherViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_listview_teacher, parent, false)
        return TeacherViewHolder(v, teacherSelectedCallback)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {

        Log.d("hello","checking purpose ")
        Log.v(ContentValues.TAG, "Teacher list size=" + teacherModelList.size)
        return teacherModelList.size
    }

    class TeacherViewHolder(val itView : View, val teacherSelectedCallback: TeacherSelectedCallback) : RecyclerView.ViewHolder(itView) {

        var teacherId = itView.findViewById(R.id.teacherId) as TextView
        var teachername  = itView.findViewById(R.id.teachername) as TextView
        var teacheraddress  = itView.findViewById(R.id.teacherAdress) as TextView

        fun bindTeacherList(teacherModel : TeacherModel){

            teacherId.text = teacherModel.teacherId.toString()
            teachername.text = teacherModel.teachername
            teacheraddress.text = teacherModel.subjectname

            itView?.setOnClickListener{
                Toast.makeText(itView.context,teachername.text,Toast.LENGTH_LONG).show()
                //itView.context.startActivity(Intent(itView.context,UpdateDetail :: class.java))
//                startActivityForResult( ,Intent(itView.context,UpdateDetail :: class.java),1)
                teacherSelectedCallback.onTeacherClicked(teacherModel)
            }
        }

    }
    interface TeacherSelectedCallback{
        fun onTeacherClicked(teacherModel: TeacherModel)
    }
}
