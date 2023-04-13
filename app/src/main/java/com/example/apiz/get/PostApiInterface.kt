package com.example.apiz.get

import com.example.apiz.Constants
import com.example.apiz.post.PostData
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface PostApiInterface {
    @GET(Constants.END_POINT_GET)
    suspend fun getAllData():Response<List<PostItem>>

    @POST(Constants.END_POINT_POST)
    suspend fun postData(
        @Body postData:PostItem
    ):Response<PostItem>

    @DELETE(Constants.END_POINT_DELETE)
    suspend fun deletePost():Response<ResponseBody>

}