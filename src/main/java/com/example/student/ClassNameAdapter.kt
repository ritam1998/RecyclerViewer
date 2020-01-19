package com.example.student

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import android.view.LayoutInflater as LayoutInflater1


class ClassNameAdapter (context: Context,var classNameList : ArrayList<AllClassName>) : Adapter<ClassNameAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ClassNameAdapter.ViewHolder, position: Int) {
        /*TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/

        holder.binditems(classNameList[position])
    }

    override fun getItemCount(): Int {
        /*TODO("not implemented") //To change body of created functions use File | Settings | File Templates. */
        Log.v("check","listsize ===="+classNameList.size)
        return classNameList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassNameAdapter.ViewHolder {

        /*TODO("not implemented") //To change body of created functions use File | Settings | File Templates.*/


        val view = LayoutInflater1.from(parent.context).inflate(R.layout.activity_listview_classname,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(var classnameview : View) : RecyclerView.ViewHolder(classnameview) {


        fun binditems(classnamelist : AllClassName){

           val textViewClass = classnameview.findViewById(R.id.classlist) as TextView
            textViewClass.text = classnamelist.className
        }
    }

}