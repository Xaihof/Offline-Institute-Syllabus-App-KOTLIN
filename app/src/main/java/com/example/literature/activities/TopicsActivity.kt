package com.example.literature.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.literature.R
import com.example.literature.adapter_classes.TopicsListAdapter
import com.example.literature.data_classes.TopicsData
import com.example.literature.databinding.ActivityTopicsBinding

class TopicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTopicsBinding
    private var topicsList = ArrayList<TopicsData>()
    private lateinit var topicsListAdapter: TopicsListAdapter
    private var tempTopicsList: ArrayList<TopicsData> = arrayListOf()
    private lateinit var universityName: String
    private lateinit var semesterNumber: String
    private lateinit var subjectName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back Button on app bar.
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        universityName = intent.getStringExtra("universityName").toString()
        semesterNumber = intent.getStringExtra("semesterNumber").toString()
        subjectName = intent.getStringExtra("subjectName").toString()
        binding.topAppBar.title = subjectName

        addDataToList()
        topicsListAdapter =
            TopicsListAdapter(tempTopicsList, universityName, semesterNumber, subjectName)
        binding.recyclerViewTopics.adapter = topicsListAdapter

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->

            when (menuItem.itemId) {

                R.id.search -> {

                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Search Topic"
                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            filterList(newText)
                            return true
                        }

                    })

                }
            }

            true
        }

    }

    private fun filterList(newText: String?) {

        tempTopicsList.clear()
        val searchText = newText!!.lowercase()
        if (searchText.isNotEmpty()) {
            topicsList.forEach {
                if (it.topicName.lowercase().contains(searchText)) {
                    tempTopicsList.add(it)
                }

            }
            binding.recyclerViewTopics.adapter?.notifyDataSetChanged()
        } else {

            tempTopicsList.clear()
            tempTopicsList.addAll(topicsList)
            binding.recyclerViewTopics.adapter?.notifyDataSetChanged()
        }
    }

    private fun addDataToList() {

        // use when for university name and inside each case use when for subjects and inside each case use when for topics.

        when (universityName) {
            "bzu" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "gcf" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "gcl" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "iub" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "ku" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "numl" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "qua" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "su" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "ucp lahore" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "uog" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "uol" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "uop" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "uos" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "up" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

            "vu" -> {

                when (semesterNumber) {
                    "1" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..5) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..11) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)

                    }

                    "2" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "3" -> {

                        when (subjectName) {
                            "english" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. English Topic"))
                                }
                            }

                            "urdu" -> {
                                for (i in 1..8) {
                                    topicsList.add(TopicsData("$i. Urdu Topic"))
                                }
                            }

                            "islamiyat" -> {
                                for (i in 1..3) {
                                    topicsList.add(TopicsData("$i. Islamiyat Topic"))
                                }
                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "4" -> {
                        when (subjectName) {
                            "pakistan studies" -> {
                                for (i in 1..6) {
                                    topicsList.add(TopicsData("$i. Pakistan Studies Topic"))
                                }
                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "5" -> {
                        when (subjectName) {
                            "literature" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Literature Topic"))
                                }

                            }
                        }

                        // SubjectList.
                        tempTopicsList.addAll(topicsList)


                    }

                    "6" -> {
                        when (subjectName) {
                            "comprehension" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Comprehension Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "7" -> {
                        when (subjectName) {
                            "ict" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. ICT Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }

                    "8" -> {
                        when (subjectName) {
                            "linear algebra" -> {
                                for (i in 1..7) {
                                    topicsList.add(TopicsData("$i. Linear Algebra Topic"))
                                }

                            }
                        }
                        // SubjectList.
                        tempTopicsList.addAll(topicsList)
                    }
                }
            }

        }


    }
}