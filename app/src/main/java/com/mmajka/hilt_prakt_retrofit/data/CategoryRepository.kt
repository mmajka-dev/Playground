package com.mmajka.hilt_prakt_retrofit.data

import androidx.lifecycle.liveData
import com.mmajka.hilt_prakt_retrofit.data.models.Category
import com.mmajka.hilt_prakt_retrofit.data.remote.CategoryRemoteDataSource
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val remote: CategoryRemoteDataSource) {

    suspend fun getCategories() = liveData(IO) {
        val response = remote.getCategories().body()
        emit(response)
    }
}