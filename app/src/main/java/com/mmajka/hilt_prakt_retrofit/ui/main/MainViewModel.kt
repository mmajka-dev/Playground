package com.mmajka.hilt_prakt_retrofit.ui.main

import androidx.lifecycle.ViewModel
import com.mmajka.hilt_prakt_retrofit.data.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CategoryRepository): ViewModel() {

    val categories = runBlocking{ repository.getCategories() }
}