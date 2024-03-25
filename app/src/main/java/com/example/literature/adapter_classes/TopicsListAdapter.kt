package com.example.literature.adapter_classes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.literature.R
import com.example.literature.activities.DetailsActivity
import com.example.literature.activities.TopicsActivity
import com.example.literature.data_classes.TopicsData

class TopicsListAdapter(
    private var topicsList: List<TopicsData>,
    private var universityName: String,
    private var semesterNumber: String,
    private var subjectName: String,
) :
    RecyclerView.Adapter<TopicsListAdapter.TopicsViewHolder>() {

    private lateinit var context: Context

    inner class TopicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicsName: TextView = itemView.findViewById(R.id.textViewTopicName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsViewHolder {

        context = parent.context
        return TopicsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_topics_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return topicsList.size
    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) {
        val topic = topicsList[position]
        holder.topicsName.text = topic.topicName
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("universityName", universityName.lowercase())
            intent.putExtra("semesterNumber", semesterNumber.lowercase())
            intent.putExtra("subjectName", subjectName.lowercase())
            intent.putExtra("topicName", topic.topicName.lowercase())
            context.startActivity(intent)
        }
    }
}