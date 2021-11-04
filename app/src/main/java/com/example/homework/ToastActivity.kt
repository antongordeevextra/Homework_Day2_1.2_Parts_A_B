package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.MainActivity.Companion.EXTRA_MESSAGE
import com.example.homework.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        binding = ActivityToastBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val intent = intent
        val count = intent.getStringExtra(EXTRA_MESSAGE)
        binding.textCount.text = count
    }
}