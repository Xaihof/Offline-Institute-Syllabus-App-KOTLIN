package com.example.literature.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.literature.R
import com.example.literature.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var universityName: String
    private lateinit var semesterNumber: String
    private lateinit var subjectName: String
    private lateinit var topicName: String
    private lateinit var topicDetail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        universityName = intent.getStringExtra("universityName").toString()
        semesterNumber = intent.getStringExtra("semesterNumber").toString()
        subjectName = intent.getStringExtra("subjectName").toString()
        topicName = intent.getStringExtra("topicName").toString()

        addDataToList()


    }

    private fun addDataToList() {

        // use when for university name and inside each case use when for subjects and inside each case use when for topics.
        when (universityName) {
            "bzu" -> {
                when (semesterNumber) {
                    "1" -> {
                        when (subjectName) {
                            "english" -> {
                                when (topicName) {
                                    "1. english topic" -> {

                                        binding.textViewHeading.text = topicName
                                        binding.textViewDetails.text =
                                            getString(R.string.english_topic)
                                    }

                                    "2. urdu topic" -> {
                                        binding.textViewHeading.text = topicName
                                        binding.textViewDetails.setText(getString(R.string.urdu_topic))
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }


    }
}