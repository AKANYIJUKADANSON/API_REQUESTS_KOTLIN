package com.example.apiz.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.apiz.R
import com.example.apiz.get.PostItem
import com.example.apiz.get.RetrofitInstance
import kotlinx.coroutines.launch

class PostData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_data)

        val postId  = findViewById<EditText>(R.id.post_data_id)
        val postTitle  = findViewById<EditText>(R.id.post_data_title)
        val postBody  = findViewById<EditText>(R.id.post_data_body)
        val postUserId  = findViewById<EditText>(R.id.post_data_user_id)
        val postButton  = findViewById<Button>(R.id.post_btn)

        postButton.setOnClickListener {

            if (postBody.text.toString().isNotEmpty() && postTitle.text.toString().isNotEmpty()) {
                makePost(
                    postId.text.toString(),
                    postTitle.text.toString(),
                    postBody.text.toString(),
                    postUserId.text.toString()
                )
            }

        }
    }

    private fun makePost(postId:String, postTitle:String, postBody:String, postUserId:String) {
        lifecycleScope.launch {
            val dataToPost = PostItem(postId, postTitle, postBody, postUserId)
            val response = RetrofitInstance.retrofit.postData(dataToPost)

            if (response.isSuccessful && response.body() != null){
                Log.e("Response", "Posted_ata: ${response.body()}")
                Toast.makeText(this@PostData, "Post made successfully", Toast.LENGTH_LONG).show()
            }else{
                Log.e("Error", "Error: ${response.code()}")
            }
        }
    }
}