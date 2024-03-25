package com.example.literature.adapter_classes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.literature.R
import com.example.literature.activities.SemestersActivity
import com.example.literature.data_classes.UniversitiesData

class UniversitiesListAdapter(var universitiesList: List<UniversitiesData>) :
    RecyclerView.Adapter<UniversitiesListAdapter.UniversitiesViewHolder>() {

    private lateinit var context: Context

    inner class UniversitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val universityLogo: ImageView = itemView.findViewById(R.id.imageViewUniversityLogo)
        val universityName: TextView = itemView.findViewById(R.id.textViewUniversityName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversitiesViewHolder {

        context = parent.context
        return UniversitiesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_universities_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return universitiesList.size
    }

    override fun onBindViewHolder(holder: UniversitiesViewHolder, position: Int) {
        val university = universitiesList[position]

        holder.universityLogo.setImageResource(university.universityLogo)
        holder.universityName.text = university.universityName

        holder.itemView.setOnClickListener {
            val intent = Intent(context, SemestersActivity::class.java)
            intent.putExtra("universityName", university.universityName.lowercase())
            context.startActivity(intent)
        }
    }
}