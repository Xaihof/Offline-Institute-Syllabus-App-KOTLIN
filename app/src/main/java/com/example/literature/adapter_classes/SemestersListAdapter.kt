package com.example.literature.adapter_classes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.literature.R
import com.example.literature.activities.SubjectsActivity
import com.example.literature.data_classes.SemestersData

class SemestersListAdapter(var semestersList: List<SemestersData>, var universityName: String) :
    RecyclerView.Adapter<SemestersListAdapter.SemestersViewHolder>() {

    private lateinit var context: Context

    inner class SemestersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val semesterNumber: TextView = itemView.findViewById(R.id.textViewSemesterNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemestersViewHolder {

        context = parent.context
        return SemestersViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_semesters_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return semestersList.size
    }

    override fun onBindViewHolder(holder: SemestersViewHolder, position: Int) {
        val semester = semestersList[position]
        holder.semesterNumber.text = "Semester no. ${semester.semesterNumber}"
        holder.itemView.setOnClickListener {
            val intent = Intent(context, SubjectsActivity::class.java)
            intent.putExtra("universityName", universityName.lowercase())
            intent.putExtra("semesterNumber", semester.semesterNumber.lowercase())
            context.startActivity(intent)
        }
    }
}