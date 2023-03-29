package com.example.apiz.get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiz.R

class GetData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)

        getAllItems()
    }

    private fun getAllItems() {
        lifecycleScope.launchWhenCreated {
            val response = RetrofitInstance.retrofit.getAllData()
            if (response.isSuccessful && response.body() != null) {
                Log.d("Response", "getAllData: ${response.body()}")

                val dataList:ArrayList<PostItem> = ArrayList(response.body())
                // setting the recyclerView
                val dataRecyclerView = findViewById<RecyclerView>(R.id.rv_get_data)
                dataRecyclerView.layoutManager = LinearLayoutManager(this@GetData)
                dataRecyclerView.setHasFixedSize(true)

                // Getting the adapter for the recyclerview
                val dataAdapter = GetDataAdapter(this@GetData, dataList)
                dataRecyclerView.adapter = dataAdapter
            }
        }
    }
}