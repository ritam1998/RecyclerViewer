package com.example.student.subject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.student.R
import com.example.student.subject.SubjectAdapter.*


class SubjectAdapter(var subjectlist : ArrayList<SubjectModel>) :
    RecyclerView.Adapter<SubjectViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var  v = LayoutInflater.from(parent.context).inflate(R.layout.activity_listview_subject,parent,false)
        return SubjectViewHolder(v)
    }

    override fun getItemCount(): Int {

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        return subjectlist.size
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.bindsubjectitem(subjectlist[position])
    }

    class SubjectViewHolder(var itView : View) : RecyclerView.ViewHolder(itView) {

        var viewsubjectlist = itView.findViewById(R.id.viewsubject) as TextView

        fun bindsubjectitem(subjectModel: SubjectModel) {

            viewsubjectlist?.text =  subjectModel.subjectname
        }
    }

}