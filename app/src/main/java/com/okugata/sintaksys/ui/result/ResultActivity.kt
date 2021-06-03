package com.okugata.sintaksys.ui.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.okugata.sintaksys.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra(RESULT)
        binding.resultTextview.text = text
    }

    companion object {
        const val RESULT = "extra_result"
    }
}