package com.example.apiz.get

import com.example.apiz.Constants
import retrofit2.Response
import retrofit2.http.GET

interface PostApiInterface {
    @GET(Constants.END_POINT_GET)
    suspend fun getAllData():Response<List<PostItem>>
}