package com.mmajka.hilt_prakt_retrofit.data.remote

import com.mmajka.hilt_prakt_retrofit.data.models.Category
import com.mmajka.hilt_prakt_retrofit.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {
    @GET(Constants.GET_CATEGORIES)
    suspend fun getCategories(): Response<List<Category>>
}