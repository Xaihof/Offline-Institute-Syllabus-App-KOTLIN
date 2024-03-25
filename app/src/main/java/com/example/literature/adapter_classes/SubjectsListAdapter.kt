package com.example.literature.adapter_classes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.literature.R
import com.example.literature.activities.TopicsActivity
import com.example.literature.data_classes.SubjectsData

class SubjectsListAdapter(
    private var subjectsList: List<SubjectsData>,
    private var universityName: String,
    private var semesterNumber: String
) :
    RecyclerView.Adapter<SubjectsListAdapter.SubjectsViewHolder>() {

    private lateinit var context: Context

    inner class SubjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.textViewSubjectName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {

        context = parent.context
        return SubjectsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_subjects_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return subjectsList.size
    }

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
        val semester = subjectsList[position]
        holder.subjectName.text = semester.subjectName
        holder.itemView.setOnClickListener {
            val intent = Intent(context, TopicsActivity::class.java)
            intent.putExtra("universityName", universityName.lowercase())
            intent.putExtra("semesterNumber", semesterNumber.lowercase())
            intent.putExtra("subjectName", semester.subjectName.lowercase())
            context.startActivity(intent)
        }
    }
}