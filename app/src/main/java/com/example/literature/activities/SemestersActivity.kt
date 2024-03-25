package com.example.literature.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.literature.R
import com.example.literature.adapter_classes.SemestersListAdapter
import com.example.literature.data_classes.SemestersData
import com.example.literature.databinding.ActivitySemestersBinding

class SemestersActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySemestersBinding
    private var semestersList = ArrayList<SemestersData>()
    private lateinit var semestersListAdapter: SemestersListAdapter
    private var tempSemestersList: ArrayList<SemestersData> = arrayListOf()
    private lateinit var universityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySemestersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back Button on app bar.
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }
        universityName = intent.getStringExtra("universityName").toString()
        binding.topAppBar.title = universityName.uppercase()


        addDataToList()
        semestersListAdapter = SemestersListAdapter(tempSemestersList, universityName)
        binding.recyclerViewSemesters.adapter = semestersListAdapter


        binding.topAppBar.setOnMenuItemClickListener { menuItem ->

            when (menuItem.itemId) {

                R.id.search -> {

                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Search Semester"
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

        tempSemestersList.clear()
        val searchText = newText!!.lowercase()
        if (searchText.isNotEmpty()) {
            semestersList.forEach {
                if (it.semesterNumber.lowercase().contains(searchText)) {
                    tempSemestersList.add(it)
                }

            }
            binding.recyclerViewSemesters.adapter?.notifyDataSetChanged()
        } else {

            tempSemestersList.clear()
            tempSemestersList.addAll(semestersList)
            binding.recyclerViewSemesters.adapter?.notifyDataSetChanged()


        }
    }

    private fun addDataToList() {
        when (universityName) {
            "bzu" -> {
                for (iterator in 1..7) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "gcf" -> {
                for (iterator in 1..9) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)

            }

            "gcl" -> {
                for (iterator in 1..15) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "iub" -> {
                for (iterator in 1..8) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "ku" -> {
                for (iterator in 1..7) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "numl" -> {
                for (iterator in 1..5) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "qua" -> {
                for (iterator in 1..8) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "su" -> {
                for (iterator in 1..9) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "ucp lahore" -> {
                for (iterator in 1..11) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "uog" -> {
                for (iterator in 1..12) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "uol" -> {
                for (iterator in 1..13) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "uop" -> {
                for (iterator in 1..10) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "uos" -> {
                for (iterator in 1..7) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "up" -> {
                for (iterator in 1..15) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

            "vu" -> {
                for (iterator in 1..14) {
                    semestersList.add(SemestersData("${iterator}"))
                }
                tempSemestersList.addAll(semestersList)
            }

        }


    }

}