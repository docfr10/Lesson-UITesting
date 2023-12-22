package com.example.lesson_uitesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson_uitesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeTextButton.setOnClickListener {
            binding.textView.text = binding.editText.text
        }

        binding.changeFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction().add(binding.frameLayout.id, BlankFragment())
                .commit()
        }
    }
}