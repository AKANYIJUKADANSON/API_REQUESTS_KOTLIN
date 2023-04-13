package com.example.apiz.get

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiz.R
import com.example.apiz.delete.DeleteData
import com.example.apiz.post.PostData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class GetData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)

        // Getting posts
        getAllItems()

        val floatingButton = findViewById<FloatingActionButton>(R.id.displayDialogFloatingActionButton)
        floatingButton.setOnClickListener {
            val intent = Intent(this@GetData, PostData::class.java)
            startActivity(intent)
            finish()
        }

        val floatingButtonDelete = findViewById<FloatingActionButton>(R.id.deleteDialogFloatingActionButton)
        floatingButtonDelete.setOnClickListener {
            deletePost()
        }
    }

    // Get all data from API
    private fun getAllItems() {
        lifecycleScope.launch {
            val response = RetrofitInstance.retrofit.getAllData()
            if (response.isSuccessful && response.body() != null) {
                Log.d("Response", "getAllData: ${response.body()}")

                val dataList:ArrayList<PostItem> = ArrayList(response.body()!!)
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

    // delete Post
    private fun deletePost(){
        DeleteData().deletePost(this)
//        lifecycleScope.launch {
//            val response = RetrofitInstance.retrofit.deletePost()
//            if (response.isSuccessful){
//                Toast.makeText(this@GetData,
//                    "Post deleted Successfully",
//                    Toast.LENGTH_LONG
//                ).show()
//            }else{
//                Toast.makeText(this@GetData,
//                    "Error while deleting post",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//        }
    }
}