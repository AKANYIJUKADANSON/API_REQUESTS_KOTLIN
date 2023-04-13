package com.example.apiz.delete

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.apiz.get.GetData
import com.example.apiz.get.RetrofitInstance
import kotlinx.coroutines.launch

class DeleteData:AppCompatActivity() {

    fun deletePost(activity:GetData){
        lifecycleScope.launch {
            val response = RetrofitInstance.retrofit.deletePost()
            if (response.isSuccessful){

                Log.e("DeleteResponse", "Response: ${response.body()}")
                Toast.makeText(activity,
                    "Post deleted Successfully",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(activity,
                    "Error while deleting post",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }
}