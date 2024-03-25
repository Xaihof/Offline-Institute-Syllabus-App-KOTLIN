package com.example.literature.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.literature.R
import com.example.literature.adapter_classes.UniversitiesListAdapter
import com.example.literature.data_classes.UniversitiesData
import com.example.literature.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var universitiesList = ArrayList<UniversitiesData>()
    private lateinit var universitiesListAdapter: UniversitiesListAdapter
    private var tempUniversitiesList: ArrayList<UniversitiesData> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back Button on app bar.
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        addDataToList()
        universitiesListAdapter = UniversitiesListAdapter(tempUniversitiesList)
        binding.recyclerViewUniversities.adapter = universitiesListAdapter


        // Search button on app bar.
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->

            when (menuItem.itemId) {

                R.id.search -> {

                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Search University"
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

        tempUniversitiesList.clear()
        val searchText = newText!!.lowercase()
        if (searchText.isNotEmpty()) {
            universitiesList.forEach {
                if (it.universityName.lowercase().contains(searchText)) {
                    tempUniversitiesList.add(it)
                }

            }
            binding.recyclerViewUniversities.adapter?.notifyDataSetChanged()
        } else {

            tempUniversitiesList.clear()
            tempUniversitiesList.addAll(universitiesList)
            binding.recyclerViewUniversities.adapter?.notifyDataSetChanged()


        }
    }

    private fun addDataToList() {
        universitiesList.add(UniversitiesData("BZU", R.drawable.bzu))
        universitiesList.add(UniversitiesData("GCF", R.drawable.gcf))
        universitiesList.add(UniversitiesData("GCL", R.drawable.gcl))
        universitiesList.add(UniversitiesData("IUB", R.drawable.iub))
        universitiesList.add(UniversitiesData("KU", R.drawable.ku))
        universitiesList.add(UniversitiesData("NUML", R.drawable.numl))
        universitiesList.add(UniversitiesData("QUA", R.drawable.qua))
        universitiesList.add(UniversitiesData("SU", R.drawable.su))
        universitiesList.add(UniversitiesData("UCP Lahore", R.drawable.ucp_lahore))
        universitiesList.add(UniversitiesData("UOG", R.drawable.uog))
        universitiesList.add(UniversitiesData("UOL", R.drawable.uol))
        universitiesList.add(UniversitiesData("UOP", R.drawable.uop))
        universitiesList.add(UniversitiesData("UOS", R.drawable.uos))
        universitiesList.add(UniversitiesData("UP", R.drawable.up))
        universitiesList.add(UniversitiesData("VU", R.drawable.vu))

        tempUniversitiesList.addAll(universitiesList)
    }
}