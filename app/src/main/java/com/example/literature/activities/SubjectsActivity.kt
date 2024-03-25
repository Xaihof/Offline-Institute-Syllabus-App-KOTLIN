package com.example.literature.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.literature.R
import com.example.literature.adapter_classes.SubjectsListAdapter
import com.example.literature.data_classes.SubjectsData
import com.example.literature.databinding.ActivitySubjectsBinding

class SubjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectsBinding
    private var subjectsList = ArrayList<SubjectsData>()
    private lateinit var subjectsListAdapter: SubjectsListAdapter
    private var tempSubjectsList: ArrayList<SubjectsData> = arrayListOf()
    private lateinit var universityName: String
    private lateinit var semesterNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back Button on app bar.
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        universityName = intent.getStringExtra("universityName").toString()
        semesterNumber = intent.getStringExtra("semesterNumber").toString()
        binding.topAppBar.title = "Semester no. $semesterNumber"

        addDataToList()
        subjectsListAdapter = SubjectsListAdapter(tempSubjectsList, universityName, semesterNumber)
        binding.recyclerViewSubjects.adapter = subjectsListAdapter

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->

            when (menuItem.itemId) {

                R.id.search -> {

                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Search Subject"
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

        tempSubjectsList.clear()
        val searchText = newText!!.lowercase()
        if (searchText.isNotEmpty()) {
            subjectsList.forEach {
                if (it.subjectName.lowercase().contains(searchText)) {
                    tempSubjectsList.add(it)
                }

            }
            binding.recyclerViewSubjects.adapter?.notifyDataSetChanged()
        } else {

            tempSubjectsList.clear()
            tempSubjectsList.addAll(subjectsList)
            binding.recyclerViewSubjects.adapter?.notifyDataSetChanged()
        }
    }

    private fun addDataToList() {

        // use when for university name and inside each case use if else for subjects.

        when (universityName) {
            "bzu" -> {

                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "gcf" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "gcl" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "iub" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "ku" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "numl" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "qua" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "su" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "ucp lahore" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "uog" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "uol" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "uop" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "uos" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "up" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }
            }

            "vu" -> {
                when (semesterNumber) {
                    "1" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("English"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)

                    }

                    "2" -> {
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Urdu"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "3" -> {
                        subjectsList.add(SubjectsData("English"))
                        subjectsList.add(SubjectsData("Urdu"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        subjectsList.add(SubjectsData("Islamiyat"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "4" -> {
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        subjectsList.add(SubjectsData("Pakistan Studies"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "5" -> {
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        subjectsList.add(SubjectsData("Literature"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)


                    }

                    "6" -> {
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        subjectsList.add(SubjectsData("Comprehension"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "7" -> {
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        subjectsList.add(SubjectsData("ICT"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }

                    "8" -> {
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        subjectsList.add(SubjectsData("Linear Algebra"))
                        // SubjectList.
                        tempSubjectsList.addAll(subjectsList)
                    }
                }

            }

        }


    }
}
