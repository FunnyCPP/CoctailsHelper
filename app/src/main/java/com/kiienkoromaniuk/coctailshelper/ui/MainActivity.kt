package com.kiienkoromaniuk.coctailshelper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiienkoromaniuk.coctailshelper.R
import com.kiienkoromaniuk.coctailshelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}