package com.mmajka.hilt_prakt_retrofit.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mmajka.hilt_prakt_retrofit.data.models.Category
import com.mmajka.hilt_prakt_retrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CategoryInterface {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        viewModel.categories.observe(this, { categories ->
            if(categories != null){
                binding.categoryRv.adapter = CategoryAdapter(categories, this)
                binding.categoryRv.layoutManager = LinearLayoutManager(this)
            }
        })
    }

    override fun onClick(position: Int, category: Category) {
        Snackbar.make(binding.root, "Click", Snackbar.LENGTH_SHORT).show()
    }

    override fun onLongClick(position: Int, category: Category) {
        Snackbar.make(binding.root, "Long Click", Snackbar.LENGTH_SHORT).show()
    }
}