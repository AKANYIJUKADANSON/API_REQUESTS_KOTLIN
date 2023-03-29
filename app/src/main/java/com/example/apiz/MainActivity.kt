package com.example.apiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.apiz.get.RetrofitInstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllItems()
    }

    private fun getAllItems() {
        lifecycleScope.launchWhenCreated {
            val response = RetrofitInstance.retrofit.getAllData()
            if (response.isSuccessful && response.body() != null){
                Log.d("Response", "getAllData: ${response.body()}" )

            }else{

                Log.e("Error", "errorMsg: ${response.code()}" )
            }
        }

    }
}