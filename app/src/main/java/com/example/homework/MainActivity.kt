package com.example.homework

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mCount = 0
    private lateinit var mShowCount: TextView

    companion object {
        private const val KEY_COUNT = "KEY_COUNT"
        const val EXTRA_MESSAGE = "extra_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        mShowCount = binding.showCount

        binding.buttonToast.setOnClickListener {
            sendToToastActivity()
        }

        binding.buttonZero.setOnClickListener {
            returnZero()
        }

        binding.buttonCount.setOnClickListener {
            countUp()
        }

        checkCount(mCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCount = savedInstanceState.getInt(KEY_COUNT)
        mShowCount.text = mCount.toString()
        checkCount(mCount)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, mCount)
    }


    private fun sendToToastActivity() {
        val intent = Intent(this, ToastActivity::class.java)
        val text = mCount.toString()
        intent.putExtra(EXTRA_MESSAGE, text)
        startActivity(intent)
    }

    private fun countUp() {
        mCount ++
        updateCounter()
    }

    private fun returnZero() {
        mCount = 0
        updateCounter()
    }

    private fun updateCounter() {
        mShowCount.text = mCount.toString()
        checkCount(mCount)
    }

    private fun checkCount (mCount: Int){
        when {
            mCount == 0 -> {
                binding.buttonZero.setBackgroundColor(Color.GRAY)
                binding.buttonCount.setBackgroundColor(Color.BLUE)
            }
            mCount %2 == 0 -> {
                binding.buttonCount.setBackgroundColor(Color.BLUE)
                binding.buttonZero.setBackgroundColor(Color.MAGENTA)
            }
            else -> {
                binding.buttonCount.setBackgroundColor(Color.GREEN)
                binding.buttonZero.setBackgroundColor(Color.MAGENTA)
            }
        }
    }
}