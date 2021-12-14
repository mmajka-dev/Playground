package com.mmajka.hilt_prakt_retrofit.data.remote

import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(private val categoryService: CategoryService) {

    suspend fun getCategories() = categoryService.getCategories()
}